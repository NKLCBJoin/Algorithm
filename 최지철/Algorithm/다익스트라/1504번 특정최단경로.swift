struct Heap<T: Comparable> {
    private var elements: [T] = []
    private let comparer: (T, T) -> Bool
    
    var isEmpty: Bool {
        return elements.count <= 1
    }
    
    var top: T? {
        return isEmpty ? nil : elements[1]
    }
    
    init(comparer: @escaping (T,T) -> Bool) {
        self.comparer = comparer
    }
    
    mutating func insert(element: T) {
        if elements.isEmpty {
            elements.append(element)
            elements.append(element)
            return
        }
        elements.append(element)
        swimUp(index: elements.count - 1)
    }
    
    mutating private func swimUp(index: Int) {
        var index = index
        while index > 1 && comparer(elements[index], elements[index / 2]) {
            elements.swapAt(index, index / 2)
            index /= 2
        }
    }
    
    mutating func pop() -> T? {
        if elements.count < 2 { return nil }
        elements.swapAt(1, elements.count - 1)
        let deletedElement = elements.removeLast()
        diveDown(index: 1)
        return deletedElement
    }
    
    mutating private func diveDown(index: Int) {
        var swapIndex = index
        var isSwap = false
        let leftIndex = index * 2
        let rightIndex = index * 2 + 1

        if leftIndex < elements.endIndex && comparer(elements[leftIndex], elements[swapIndex]) {
            swapIndex = leftIndex
            isSwap = true
        }
        
        if rightIndex < elements.endIndex && comparer(elements[rightIndex], elements[swapIndex]) {
            swapIndex = rightIndex
            isSwap = true
        }

        if isSwap {
            elements.swapAt(swapIndex, index)
            diveDown(index: swapIndex)
        }
    }
}

struct Data: Comparable {
    static func < (lhs: Data, rhs: Data) -> Bool {
        return lhs.cost < rhs.cost
    }
    let node: Int
    let cost: Int
}

let input = readLine()!.split(separator: " ").map { Int($0)! }
let n = input[0], e = input[1]
let INF = 1_234_567_890

var graph = [[Data]](repeating: [], count: n + 1)
var distance = [Int](repeating: INF, count: n + 1)

for _ in 0..<e {
    let input = readLine()!.split(separator: " ").map { Int($0)! }
    let a = input[0], b = input[1], cost = input[2]
    graph[a].append(Data(node: b, cost: cost))
    graph[b].append(Data(node: a, cost: cost))
}

let v = readLine()!.split(separator: " ").map { Int($0)! }
let v1 = v[0], v2 = v[1]

func dijkstra(start: Int) {
    var heap = Heap<Data>(comparer: <)
    heap.insert(element: Data(node: start, cost: 0))
    distance = [Int](repeating: INF, count: n + 1)
    distance[start] = 0
    
    while !heap.isEmpty {
        let now = heap.pop()!
        
        if distance[now.node] < now.cost {
            continue
        }
        
        for next in graph[now.node] {
            let cost = now.cost + next.cost
            if cost < distance[next.node] {
                distance[next.node] = cost
                heap.insert(element: Data(node: next.node, cost: cost))
            }
        }
    }
}

// 경로 1. start -> v1 -> v2 -> n
// 경로 2. start -> v2 -> v1 -> n
// 경로 1, 2의 거리를 담을 배열
var answer = [0, 0]

dijkstra(start: 1)

// 경로 1. start -> v1 최소비용
answer[0] += distance[v1]

// 경로 2. start -> v2 최소비용
answer[1] += distance[v2]

dijkstra(start: v1)

// 경로 1. v1 -> v2 최소비용
answer[0] += distance[v2]

// 경로 2. v1 -> n 최소비용
answer[1] += distance[n]

dijkstra(start: v2)

// 경로 1. v2 -> n 최소비용
answer[0] += distance[n]

// 경로 2. v2 -> v1 최소비용
answer[1] += distance[v1]

let minDistance = answer.min()!

print(minDistance >= INF ? -1 : minDistance)

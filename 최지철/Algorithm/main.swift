import Foundation


let input = readLine()!.split(separator: " ").map { Int($0)! }
let n = input[0], m = input[1], r = input[2]
var visited = [Int](repeating: 0, count: n + 1)
var graph = [[Int]](repeating: [], count: n + 1)

for _ in 0..<m {
    let input = readLine()!.split(separator: " ").map { Int($0)! }
    let u = input[0], v = input[1]
    graph[u].append(v)
    graph[v].append(u)
}

var depth = 1 

func bfs(node: Int) {

    var queue = [node]
    var index = 0
    visited[node] = depth
    
    while queue.count > index {
        let currentNode = queue[index]
        
        for nextNode in graph[currentNode].sorted(by: >) {
            if visited[nextNode] == 0 {
                depth += 1
                visited[nextNode] = depth
                queue.append(nextNode)
            }
        }
        index += 1
    }
}
bfs(node: r)

print(visited[1...].map { String($0) }.joined(separator: "\n"))

//import Foundation
//
//struct PriorityQueue<T> {
//  var array = [T]()
//  let sort: (T, T) -> Bool
//
//  init(sort: @escaping (T, T) -> Bool) {
//    self.sort = sort
//  }
//
//  var isEmpty: Bool {
//    return array.isEmpty
//  }
//
//  var count: Int {
//    return array.count
//  }
//
//  func peek() -> T? {
//    return array.first
//  }
//
//  func leftChildIndex(ofParentAt index: Int) -> Int {
//    return (2 * index) + 1
//  }
//
//  func rightChildIndex(ofParentAt index: Int) -> Int {
//    return (2 * index) + 2
//  }
//
//  func parentIndex(ofChildAt index: Int) -> Int {
//    return (index - 1) / 2
//  }
//
//  // MARK:- remove operation
//  mutating func pop() -> T? {
//    guard !isEmpty else {
//      return nil
//    }
//
//    array.swapAt(0, count - 1)
//    defer {
//      siftDown(from: 0)
//    }
//    return array.removeLast()
//  }
//
//  mutating func siftDown(from index: Int) {
//    var parent = index
//    while true {
//      let left = leftChildIndex(ofParentAt: parent)
//      let right = rightChildIndex(ofParentAt: parent)
//      var candidate = parent
//
//      if left < count && sort(array[left], array[candidate]) {
//        candidate = left
//      }
//      if right < count && sort(array[right], array[candidate]) {
//        candidate = right
//      }
//      if candidate == parent {
//        return
//      }
//      array.swapAt(parent, candidate)
//      parent = candidate
//    }
//  }
//
//  // MARK:- insert operation
//  mutating func push(_ element: T) {
//    array.append(element)
//    siftUp(from: array.count - 1)
//  }
//
//  mutating func siftUp(from index: Int) {
//    var child = index
//    var parent = parentIndex(ofChildAt: child)
//    while child > 0 && sort(array[child], array[parent]) {
//      array.swapAt(child, parent)
//      child = parent
//      parent = parentIndex(ofChildAt: child)
//    }
//  }
//}
//
//let input = readLine()!.split(separator: " ").map { Int($0)! }
//
//let v = input[0]
//let e = input[1]
//
//let k = Int(readLine()!)!
//
//var graph = Array(repeating: [(Int, Int)](), count: v + 1)
//
//for _ in 0..<e {
//    let input = readLine()!.split(separator: " ").map { Int($0)! }
//    let u = input[0]
//    let v = input[1]
//    let w = input[2]
//    graph[u].append((v, w))
//}
//
//var distance = Array(repeating: Int.max, count: v + 1)
//distance[k] = 0
//
//var pq = PriorityQueue<(Int, Int)>(sort: { $0.1 < $1.1 })
//pq.push((k, 0))
//
//while !pq.isEmpty {
//    let (node, dist) = pq.pop()!
//    if dist > distance[node] {
//        continue
//    }
//    for (nextNode, weight) in graph[node] {
//        let newDist = distance[node] + weight
//        if newDist < distance[nextNode] {
//            distance[nextNode] = newDist
//            pq.push((nextNode, newDist))
//        }
//    }
//}
//
//for i in 1...v {
//    if distance[i] == Int.max {
//        print("INF")
//    } else {
//        print(distance[i])
//    }
//}

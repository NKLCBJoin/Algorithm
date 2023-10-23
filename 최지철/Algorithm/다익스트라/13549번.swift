//import Foundation
//
//struct Queue {
//    var que: [Int] = []
//    mutating func push(_ x: Int) {
//        que.append(x)
//    }
//    mutating func pop() -> Int {
//        que.reverse()
//        if let a = que.popLast() {
//            que.reverse()
//            return a
//        }
//        return 0
//    }
//    func empty() -> Bool {
//        return que.isEmpty
//    }
//    func size() -> Int{
//        return que.count
//    }
//}
//
//let input = readLine()!.split(separator: " ").map { Int($0)! }
//
//let subin = input[0]
//let bro = input[1]
//
//func bfs(s: Int, b: Int) -> Int {
//    var visited = [Int](repeating: -1, count: 100002)
//
//    var queue = Queue()
//
//    queue.push(s)
//    visited[s] = 0
//
//    while !queue.empty() {
//        let current = queue.pop()
//
//        if current == b {
//            return visited[current]
//        }
//
//        for next in [current - 1, current + 1] {
//            if next >= 0 && next <= 100000 && visited[next] == -1 {
//                visited[next] = visited[current] + 1
//                queue.push(next)
//            }
//        }
//    }
//
//    return -1
//}
//
//let result = bfs(s: subin, b: bro)
//
//print(result)
//

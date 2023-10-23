////
////  1260.swift
////  Algorithm
////
////  Created by 최지철 on 2023/09/18.
////
//
//import Foundation
//let input = readLine()!.split(separator: " ").map { Int($0)! }
//let n = input[0], m = input[1], r = input[2]
//
//var visited = [Bool](repeating: false, count: n + 1)
//var graph = [[Int]](repeating: [], count: n + 1)
//
//for _ in 0..<m {
//    let input = readLine()!.split(separator: " ").map { Int($0)! }
//    let u = input[0], v = input[1]
//    graph[u].append(v)
//    graph[v].append(u)
//}
//graph = graph.map {$0.sorted()}
//
//func dfs(node:Int){
//    visited[node] = true
//    print(node,terminator: " ")
//
//    for nextnode in graph[node]{
//        if !visited[nextnode]{
//            dfs(node: nextnode)
//        }
//    }
//
//}
//
//func bfs(node: Int) {
//var queue = [node]
//var index = 0
//    visited[node] = true
//while queue.count > index {
//let currentNode = queue[index]
//print(currentNode, terminator: " ")
//for nextNode in graph[currentNode] {
//if !visited[nextNode] {
//                visited[nextNode] = true
//                queue.append(nextNode)
//            }
//        }
//        index += 1
//    }
//}
//
//dfs(node: r)
//
//
//visited = [Bool](repeating: false, count: n + 1)
//print("")
//bfs(node: r)
//

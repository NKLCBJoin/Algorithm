////
////  2606번 바이러스 실버3.swift
////  Algorithm
////
////  Created by 최지철 on 2023/09/18.
////
//
//import Foundation
//
//let N = Int(readLine()!)!
//let e = Int(readLine()!)!
//var visited = [Bool](repeating: false, count: N + 1)
//
//
//var graph = [[Int]](repeating: [], count: N + 1)
//
//for _ in 0..<e {
//    let input = readLine()!.split(separator: " ").map { Int($0)! }
//    let u = input[0], v = input[1]
//    graph[u].append(v)
//    graph[v].append(u)
//}
//
//var depth = 1
//
//func dfs(start:Int){
//    visited[start] = true
//    for nextNode in graph[start].sorted(by: <) {
//        if visited[nextNode] == false {
//            visited[nextNode] = true
//            dfs(start: nextNode)
//        }
//    }
//}
//dfs(start: 1)
//var count = 0
//for i in 0..<visited.count {
//    if visited[i] == true {
//        count += 1
//    }
//}
//print(count-1)

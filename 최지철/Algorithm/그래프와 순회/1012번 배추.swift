////
////  main.swift
////  Algorithm
////
////  Created by 최지철 on 2023/10/10.
////
//
//import Foundation
//
//let T = Int(readLine()!)!
//
//for _ in 0..<T {
//    let MNK = readLine()!.split(separator: " ").map {Int($0)!}
//    var graph = [[Int]](repeating: [Int](repeating: 0, count: MNK[0]), count: MNK[1])
//    
//    for _ in 0..<MNK[2]{
//        let input = readLine()!.split(separator: " ").map {Int($0)!}
//        graph[input[1]][input[0]] = 1
//    }
//    var result = 0 // 배추흰지렁이 수 초기화
//    
//    for i in 0..<MNK[1] {
//        for j in 0..<MNK[0] {
//            if graph[i][j] == 1 {
//                dfs(x: j, y: i, graph: &graph) // DFS로 배추 그룹 탐색
//                result += 1 // 배추흰지렁이 수 증가
//            }
//        }
//    }
//    
//    print(result)
//}
//
//func dfs(x: Int, y: Int, graph: inout [[Int]]) {
//    let dx = [0, 0, -1, 1]
//    let dy = [1, -1, 0, 0]
//    
//    graph[y][x] = 0 // 해당 위치의 배추를 방문했다고 표시
//    
//    for i in 0..<4 {
//        let nx = x + dx[i]
//        let ny = y + dy[i]
//        
//        if nx >= 0 && nx < graph[0].count && ny >= 0 && ny < graph.count {
//            if graph[ny][nx] == 1 {
//                dfs(x: nx, y: ny, graph: &graph) // 인접한 배추를 방문
//            }
//        }
//    }
//}

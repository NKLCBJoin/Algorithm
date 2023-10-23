////
////  main.swift
////  Algorithm
////
////  Created by 최지철 on 2023/10/11.
////
//
//import Foundation
//
//let inputSize = readLine()!.split(separator: " ").map {Int($0)!}
//var maze = [[Int]](repeating: [Int](repeating: 0, count: inputSize[1]),count: inputSize[0])
//var count = 0
//for i in 0..<inputSize[0] {
//    let input = readLine()!.map { String($0) }.compactMap { Int($0) }
//
//    for j in 0..<inputSize[1]{
//        maze[i][j] = input[j]
//    }
//}
//let n = inputSize[0]
//let m = inputSize[1]
//let dx = [-1, 1, 0, 0]
//let dy = [0, 0, -1, 1]
//
//// BFS 함수 정의
//func bfs(startX: Int, startY: Int) -> Int {
//    var queue = [(startX, startY, 1)]
//
//    while !queue.isEmpty {
//        let (x, y, count) = queue.removeFirst()
//
//        // 도착 지점에 도달한 경우
//        if x == m - 1 && y == n - 1 {
//            return count
//        }
//
//        for i in 0..<4 {
//            let nx = x + dx[i]
//            let ny = y + dy[i]
//
//            if nx >= 0 && nx < m && ny >= 0 && ny < n && maze[ny][nx] == 1 {
//                // 방문한 곳은 0으로 표시하여 중복 방문을 방지
//                maze[ny][nx] = 0
//                queue.append((nx, ny, count + 1))
//            }
//        }
//    }
//
//    return -1 // 도착 지점에 도달하지 못한 경우
//}
//
//// (0, 0)에서 시작하여 BFS 실행
//let result = bfs(startX: 0, startY: 0)
//print(result)
//

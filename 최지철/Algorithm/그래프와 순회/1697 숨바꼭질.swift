//
//  main.swift
//  Algorithm
//
//  Created by 최지철 on 2023/10/11.
//

import Foundation
struct Queue{
    var que: [Int] = []
    mutating func push(_ x: Int) {
        que.append(x)
    }
    mutating func pop() -> Int {
        que.reverse()
        if let a = que.popLast() {
            que.reverse()
            return a
        }
        return 0
    }
    func empty() -> Bool {
        return que.isEmpty
    }
    func size() -> Int{
        return que.count
    }
}
let input = readLine()!.split(separator: " ").map { Int($0)!}

let subin = input[0]
let bro = input[1]

func bfs(s: Int, b: Int) -> Int {
    var visited = [Int](repeating: -1, count: 100001) // 누적된 거리를 저장하는 배열
    
    var queue = Queue()
    
    queue.push(s)
    visited[s] = 0 // 시작 위치는 거리 0
    
    while !queue.empty() {
        let current = queue.pop()
        
        if current == b {
            return visited[current]
        }
        
        for next in [current - 1, current + 1, current * 2] {
            if next >= 0 && next <= 100000 && visited[next] == -1 {
                visited[next] = visited[current] + 1 // 현재 위치의 거리에서 1을 더함
                queue.push(next)
            }
        }
    }
    
    return -1
}

let result = bfs(s: subin, b: bro)
print(result)

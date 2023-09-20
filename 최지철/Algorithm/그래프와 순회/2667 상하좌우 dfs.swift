//
//  main.swift
//  Algorithm
//
//  Created by 최지철 on 2023/09/18.
//

import Foundation

let n = Int(readLine()!)!
var graph = [[Int]]()
var visited = Array(repeating: Array(repeating: false, count: n + 1), count: n + 1)

let dx = [0,0,1,-1]
let dy = [1,-1,0,0]
var result:[Int] = []

var count = 0

for _ in 0..<n{
    graph.append(Array(readLine()!).map{Int(String($0))!})
}

func dfs(x:Int,y:Int){
    count += 1
    visited[x][y] = true
    for i in 0..<4 {
        let nx = x+dx[i]
        let ny = y+dy[i]
        
        if nx>=0 && nx < n && ny>=0 && ny < n{
            if graph[nx][ny] == 1 && !visited[nx][ny]{
                dfs(x: nx, y: ny)
            }
        }
    }
}

for i in 0..<n{
    for j in 0..<n{
        if graph[i][j] == 1 && !visited[i][j]{
            count = 0
            dfs(x: i, y: j)
            result.append(count)
        }
    }
}

print(result.count)
result.sort()
print(result.map{String($0)}.joined(separator: "\n"))



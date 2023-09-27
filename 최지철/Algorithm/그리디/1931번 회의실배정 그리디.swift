//
//  main.swift
//  Algorithm
//
//  Created by 최지철 on 2023/09/25.
//

import Foundation

let N = Int(readLine()!)!
var room : [(strat: Int, end: Int)] = []
var meeting = 0
var end = 0

for _ in 0..<N {
    let input = readLine()!.split(separator: " ").map { Int($0)! }
    let s = input[0] , e = input[1]
    room.append((s,e))
}

room.sort(by:{$0.1 == $1.1 ? $0.0 < $1.0 : $0.1 < $1.1 })

for i in room {
    if i.strat >= end {
        meeting += 1
        end = i.end
    }
}

print(meeting)

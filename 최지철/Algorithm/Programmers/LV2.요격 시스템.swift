//
//  main.swift
//  Algorithm
//
//  Created by 최지철 on 2023/10/23.
//

import Foundation

import Foundation

let input = [[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]

func solution(_ targets:[[Int]]) -> Int {
    var result = 0
    let sorted = targets.sorted{$0[1] < $1[1]}
    
    var end = sorted[0][1]
    
    for i in sorted {
        if i[0] >= end {
            end = i[1]
            result += 1
        }
    }
    
    return result + 1
}

print(solution(input))

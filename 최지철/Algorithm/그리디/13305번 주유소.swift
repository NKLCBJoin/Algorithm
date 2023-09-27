//
//  main.swift
//  Algorithm
//
//  Created by 최지철 on 2023/09/26.
//

import Foundation

let city = Int(readLine()!)!

let load = readLine()!.split(separator: " ").map { Int($0)! }

let price = readLine()!.split(separator: " ").map { Int($0)! }

var minPrice = price[0]

func sum(ary:[Int]) -> Int {
    return ary.reduce(0, +)
}

let totalDis = sum(ary: load)

var result = 0

for i in 0..<price.count - 1{
    if minPrice > price[i] {
        minPrice = price[i]
    }
    result += minPrice * load[i]
}

print(result)

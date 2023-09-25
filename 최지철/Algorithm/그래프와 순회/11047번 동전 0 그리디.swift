//
//  main.swift
//  Algorithm
//
//  Created by 최지철 on 2023/09/19.
//

import Foundation

let nk = readLine()!.split(separator: " ").map { Int($0)! }

let n = nk[0]
let k = nk[1]
var Coins = [Int]()
var count = 0
for _ in 0..<n {
    let input = Int(readLine()!)!
    Coins.append(input)
}

Coins.sort(by: >)

func coinCounter(value: Int , coins: [Int]) -> Int {
    var money = value
    for i in 0..<coins.count{
        if coins[i] <= value {
            count += money / coins[i]
            money = money % coins[i]
        }
    }
    return count
}
print(coinCounter(value: k, coins: Coins))

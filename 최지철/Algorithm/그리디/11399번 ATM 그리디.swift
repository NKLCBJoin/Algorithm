//
//  main.swift
//  Algorithm
//
//  Created by 최지철 on 2023/09/25.
//

import Foundation

let N = Int(readLine()!)!

var person = readLine()!.split(separator: " ").map {Int($0)!}
var sum = 0
var time = [Int]()
person.sort(by: <)

func sum(ary:[Int]) -> Int {
    return ary.reduce(0, +)
}

for i in person {
    time.append(i)
    sum += sum(ary: time)
}

print(sum)

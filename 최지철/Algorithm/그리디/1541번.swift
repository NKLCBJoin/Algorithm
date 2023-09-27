////
////  main.swift
////  Algorithm
////
////  Created by 최지철 on 2023/09/26.
////
//
//import Foundation
//
//let readline = String(readLine()!)
//
//let input = readline.split(separator: "-").map {String($0)}
//let nominus:Bool = readline.contains("-")
//func sum(ary:[Int]) -> Int {
//    return ary.reduce(0, +)
//}
//var result = 0
//for i in 0..<input.count {
//    let n = input[i].split(separator: "+").map {Int($0)!}
//
//    if nominus == false {
//        result = sum(ary: n)
//    }
//    else{
//        if i == 0 {
//            result += Int(input[i])!
//        }
//        else{
//            result -= sum(ary: n)
//        }    }
//}
//print(result)
//
//import Foundation
//
//var input = readLine()!.split(separator: "-").map({String($0)}) // "-" 기준으로 나눠 배열 생성
//var sum = 0
//var tmp = 0
//
//for i in 0..<input.count {
//    let n = input[i].split(separator: "+").map({Int(String($0))!}) // "+"로 다시 한 번 나누기
//    for j in n { tmp += j } // "+"로 나눈 배열의 모든 요소 더하기
//
//    if i == 0 { sum += tmp } // 첫 번째 요소의 경우에만 sum에 더해주기
//    else { sum -= tmp } // 첫 번째 요소를 제외, "-"를 기준으로 나눈것이기 때문에 sum에서 빼주기
//    tmp = 0 // tmp 초기화
//}
//
//print(sum)

#!/usr/bin/env bash


pipeline {
    agent any
    stages{
    stage("list"){
    steps{
    sh "ls -l"
 }
}
}
}
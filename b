#!/bin/bash
sbt --client run && cp ./target/scala-3.7.4/frwsth-fastopt/main.js ./server && cp ./target/scala-3.7.4/frwsth-fastopt/main.js.map ./server

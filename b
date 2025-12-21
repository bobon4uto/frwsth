#!/bin/bash
sbt --client fastLinkJS && cp ./target/scala-3.7.4/frwsth-fastopt/main.js ./build && cp ./target/scala-3.7.4/frwsth-fastopt/main.js.map ./build


rm index.html
echo '<!DOCTYPE html>
<html lang="en">
<head>
<style>
* {
    margin: 0;
    padding: 0;
}
body {
    display: flex;
    justify-content: center; /* Center horizontally */
    align-items: center;    /* Center vertically */
    height: 100vh;         /* Full height of viewport */
    margin: 0;             /* Remove default margin */
}
</style>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FRWSTH</title>
    <script>' >> index.html
cat build/main.js >> index.html
echo '</script>
</head>
<body>
		<canvas id="game-canvas" style="background-color: #fafafa; margin: 0; padding: 0;" width=300 height=300></canvas>
</body>
</html>' >> index.html


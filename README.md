# frwsth

### Usage

to compile run ./b,  
or manually run 'sbt fastLinkJS' and copy resulting  
./target/scala-3.7.4/frwsth-fastopt/main.js and main.js.map 
(they are in the same folder)
to ./build, 
then copy contents of main.js into \<script\> of index.html, 
or specify main.js as the scriptfile. 
(note that in ./b bash script it constructs index.html for you. )
inside this folder (where README.md is) run some http server  
(e.g. python -m http.server if not installed  
install with python -m pip install http  
usually it comes bundled with python though)
and you can view the game in the browser afterwards  
(default for python is 127.0.0.1:8000)
or just open index.html in browser... oops, forgor that this works too.


/*Console.WriteLine("Hello bruvs");
    for whatever reason I can execute this line of code without any 
    structure/things around/before it. Weird. Experiment later */

// To create a c# program, download .Net online and C# on VSC market thingy
// Follow tutorial, https://www.youtube.com/watch?v=CO4BGZOuUkM
// Create your program folder, then in the folder click the path director
// and type cmd, then in the terminal type dotnet new console 
// then type code . 
using System;

namespace learning
{
    class Program
    {
        static void Main(string[] args)
        {
            int x = 3;
            int y = 4;
            Console.WriteLine(x+y);
        }
    }
}
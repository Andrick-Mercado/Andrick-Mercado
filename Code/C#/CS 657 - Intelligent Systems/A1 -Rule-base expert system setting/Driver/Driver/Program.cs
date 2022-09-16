using System;

namespace Driver
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Hello World");
            
            /** TESTING ZONE **/
            isRandom = input("Should this test be made with pre designated values? (0 is false, 1 is true) : ")
            if int(isRandom) == 0:
            fileName = str(input("where is the output directory? : "))
            sizeRows = int(input("how many rows should this test run have? : "))
            sizeCols = int(input("how many columns should this test run have? : "))
            startLocRow = int(input("What row should the robot start in? : "))
            startLocCol = int(input("What column should the robot start in? : "))
            endLocRow = int(input("What row should the robot end in? : "))
            endLocCol = int(input("What column should the robot end in? : "))
            direction = int(input("What direction should it be facing? ex 0 is north, 4 is south, 6 is West..."))
            difficulty = float(input("Obstacle percentage ? ex .55 is 45% obstacles :"))
            maxMoves = int(input("Max number of moves the robot has before stopping? :"))

            else:
            fileName = str(input("where is the output directory? ex C:\\\\Users\\\\name\\\\Desktop : "))
            sizeRows = 35
            sizeCols = 45
            startLocRow = 5
            startLocCol = 7
            endLocRow = 30
            endLocCol = 40
            direction = 4
            difficulty = 0.55
            maxMoves = 5000

            array_map_01 = [ [2]*sizeCols for i in range(sizeRows)] 
            array_map_01[startLocRow][startLocCol] = 1 
            array_map_01[endLocRow][endLocCol] = 'D' 

            test_01 = StudentSolution(array_map_01,startLocRow, startLocCol, direction, difficulty, maxMoves, fileName)
            test_01.solution()
            test_01.print_robot_moves_map()
            print("Solution should be ready in the file specified" )
            print("if no solution found most likely unsolvable board")
                
            Console.ReadLine();
        }
    }
}
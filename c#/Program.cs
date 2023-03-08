class Program {

    private static int Solve(string[ ] input) {
        int waitingTime= int.MaxValue,
            targetBusID= 0;

        var earliestDepartureTime= int.Parse(input[0]);

        foreach(var item in input[1].Split(",")) {
            if(item == "x")
                continue;

            int busID= int.Parse(item);

            if(earliestDepartureTime % busID == 0) {
                waitingTime= 0;
                targetBusID= busID;

                break;
            }
            else if(busID - (earliestDepartureTime % busID) < waitingTime) {
                waitingTime= busID - (earliestDepartureTime % busID);
                targetBusID= busID;
            }
        }

        return waitingTime * targetBusID;
    }

    public static void Main(string[ ] args) {
        string[ ] lines= System.IO.File.ReadAllLines("./input.txt");
        int solution= Solve(lines);

        Console.WriteLine("solution is " + solution);
    }

}
object CaesarCipher{
    def main(args:Array[String])
    {
        print("-----------------------------------------");
        println("\n\tData Encriptor-Decriptor");
        println("-----------------------------------------");

        print("\n1. Encript\n2. Decript\n3. Exit\n\nSelect Task                : ");
        val task = scala.io.StdIn.readInt();

        print("\nEnter String               : ");
        val str = scala.io.StdIn.readLine();

        print("\nEnter Shifting Number(<26) : ");
        val shift = scala.io.StdIn.readInt();

        print("\nSelect Shifting Side(R/L)  : ");
        val side = scala.io.StdIn.readLine();

        val alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        if(task==1 && (side=="R" || side=="r"))
        {
            println("\nEncription Result          : "+cipher(encryptR,str,shift,alphabet));
        }
        else if(task==1 && (side=="L" || side=="l"))
        {
            println("\nEncription Result          : "+cipher(encryptL,str,shift,alphabet));
        }
        else if(task==2 && (side=="R" || side=="r"))
        {
            println("\nDecription Result          : "+cipher(decryptR,str,shift,alphabet));
        }
        else if(task==2 && (side=="L" || side=="l"))
        {
            println("\nDecription Result          : "+cipher(decryptL,str,shift,alphabet));   
        }
        else
        {
            println("\nEncription failed.");
        }
    }
    
    val encryptR=(c:Char,key:Int,a:String)=>a((a.indexOf(c.toUpper)+key)%a.size)
    val encryptL=(c:Char,key:Int,a:String)=>a((a.indexOf(c.toUpper)-key+a.size)%a.size)
    val decryptL=(c:Char,key:Int,a:String)=>a((a.indexOf(c.toUpper)-key+a.size)%a.size)
    val decryptR=(c:Char,key:Int,a:String)=>a((a.indexOf(c.toUpper)+key)%a.size)
    val cipher=(algo:(Char,Int,String)=>Char,s:String,key:Int,a:String)=>s.map(algo(_,key,a))
}

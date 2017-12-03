import java.util.*;

public class AIAgent{
  Random rand;
  ChessProject chess;

  public AIAgent(){
    rand = new Random();
  }

/*
  The method randomMove takes as input a stack of potential moves that the AI agent
  can make. The agent uses a rondom number generator to randomly select a move from
  the inputted Stack and returns this to the calling agent.
*/
  public Move randomMove(Stack possibilities){
    int moveID = rand.nextInt(possibilities.size());
    System.out.println("Agent randomly selected move : "+moveID);
    for(int i=1;i < (possibilities.size()-(moveID));i++){
      possibilities.pop();
    }
    Move selectedMove = (Move)possibilities.pop();
    return selectedMove;
  }

//
// Does not work
// Attempted
//
  public Move nextBestMove(Stack possibilities){
  Move selectedMove;
  //chess piece value auto 0
   int pieceValue = 0;
   //square piece auto worth 0
   int squarePiece = 0;
   //get square piece can move to
   Square blackpiecequare;
   //find all black Pieces
   Stack whitesquarestack = (Stack) possibilities;

   //if the stack is not empty
   while(!whitesquarestack.isEmpty()){
     pieceValue = 0;
     selectedMove = (Move) whitesquarestack.pop();
     //pop sqaure possibilities
     blackpiecequare = (Square) whitesquarestack.pop();

     //if move XC = square XC and move YC = square XC then check if there is a piece on landing square
     if ((selectedMove.getLanding().getXC() == blackpiecequare.getXC()) && (selectedMove.getLanding().getYC() == blackpiecequare.getYC())) {
       //if piece on square is a pawn its piece value is 1
       if (blackpiecequare.getName().contains("BlackPawn")) {
         //assign value
           pieceValue = 1;
       }
       else if (blackpiecequare.getName().contains("BlackBishop")) {
         //assign value
           pieceValue = 3;
       }
       else if(blackpiecequare.getName().contains("BlackKnight")){
         //assign value
           pieceValue = 3;
       }
       else if (blackpiecequare.getName().contains("BlackRook")) {
         //assign value
           pieceValue = 5;
       }
       else if (blackpiecequare.getName().contains("BlackQueen")) {
         //assign value
           pieceValue = 9;
       }
     }
     //check to see if pieceValue higher than square value 0
     if(pieceValue > squarePiece){
       //pop moves if piece balue higher
       selectedMove = (Move) whitesquarestack.pop();
       return selectedMove;
     }

     whitesquarestack = (Stack) possibilities.pop();
   }

   //return possibilites to random move ^^
   return randomMove(whitesquarestack);
  }

  public Move twoLevelsDeep(Stack possibilities){
    Move selectedMove = new Move();
    return selectedMove;
  }


}

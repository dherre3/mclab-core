package DependenceAnalysis;
import natlab.ast.ForStmt;
import natlab.ast.Expr;
import natlab.ast.Stmt;
import natlab.ast.ParameterizedExpr;
import natlab.ast.ExprStmt;
import natlab.ast.AssignStmt;
import natlab.ast.PlusExpr;
import natlab.ast.NameExpr;
import natlab.DecIntNumericLiteralValue;
import natlab.ast.IntLiteralExpr;
import natlab.ast.MinusExpr;
import natlab.ast.Name;
import java.math.BigInteger;
import natlab.ast.RangeExpr;
import natlab.ast.ColonExpr;
/*
 * Author:Amina Aslam
 * Date:15June,2009
 * Gcd Test class determines whether there is a dependency in system of equations or not.
 */

public class GcdTest {
	
	private ForStmt forNode;
	private static boolean resultArray[];
	
	public GcdTest(ForStmt fNode)	
	{
		forNode=fNode;
		checkSameArrayAccess();
		
	}
	private void isTightlyNestedLoop(ForStmt forStmt)
	{
		
		  Stmt stmt=forStmt.getStmt(0);
		  if(stmt instanceof ForStmt)
		  {
			  ForStmt tForStmt=(ForStmt)stmt;
			  forNode=tForStmt;
			  isTightlyNestedLoop(tForStmt);				  
		  }
		
	}
	
//This function checks whether accessed arrays are the same or not.	
	private void checkSameArrayAccess()
	{
		
		isTightlyNestedLoop(forNode);
				
		int nStmts=forNode.getNumStmt();
		
		for(int i=0;i<nStmts;i++)
		{
		  Stmt stmt=forNode.getStmt(i);		  
		  for(int j=i;j<nStmts;j++)
		  if(stmt instanceof ExprStmt)
		  {
			  System.out.println("I am in Expression Statement");
		  }//end of if
		  else if(stmt instanceof AssignStmt)
		  {
			  System.out.println("I am in Assignment statement");
			  AssignStmt aStmt=(AssignStmt)stmt;  
			 
			 
			  if(aStmt.getLHS() instanceof ParameterizedExpr)
			  { 			  
				  if(aStmt.getRHS() instanceof ParameterizedExpr)
				  {					  
					  if(aStmt.getLHS().getVarName().equals(aStmt.getRHS().getVarName()))
					  {						
						  makeEquationsForSubscriptExprs(aStmt,aStmt.getRHS());
						  reportTestResult(((ParameterizedExpr)aStmt.getLHS()).getNumArg());
					  }
			      }				 
				  else if (aStmt.getRHS() instanceof PlusExpr)
				  {
					  PlusExpr pExpr=(PlusExpr)aStmt.getRHS();					  
					    if(aStmt.getLHS().getVarName().equals(pExpr.getLHS().getVarName()))
					    	{	  makeEquationsForSubscriptExprs(aStmt,pExpr.getLHS());				    		  
					    		  reportTestResult(((ParameterizedExpr)aStmt.getLHS()).getNumArg());
					    		  
					    	}						    
					    if(aStmt.getLHS().getVarName().equals(pExpr.getRHS().getVarName()))
					    	{ makeEquationsForSubscriptExprs(aStmt,pExpr.getRHS());
				    		  reportTestResult(((ParameterizedExpr)aStmt.getLHS()).getNumArg());					    	
					        }					
				  }//end of PlusExpr else if
				    
			  }//end of ParameterizedExpr if	
			  			  
		  }//end of Assign Stmt else if 
		  
		  
		}//end of for loop	
		
	}//end of function checkSameArrayAccess.
	
	
	
	//This function makes equations from array subscript expression.
	private void makeEquationsForSubscriptExprs(AssignStmt aStmt,Expr RHSExpr)
	{
		ParameterizedExpr paraLHSExpr=(ParameterizedExpr)aStmt.getLHS();
		AffineExpression aExpr1=new AffineExpression();
		AffineExpression aExpr2=new AffineExpression();
		
		resultArray=new boolean[paraLHSExpr.getNumArg()];   //instantiate a boolean array based on dimensions of array under dependence testing.

		
		if(RHSExpr instanceof ParameterizedExpr)
		{
							
			 for(int i=0;i < paraLHSExpr.getNumArg();i++)   // To handle multi dimensional arrays. e.g.a(i,j)=a(j-11,i+10)
			 {	
		
				 if(paraLHSExpr.getArg(i) instanceof NameExpr && ((ParameterizedExpr)RHSExpr).getArg(i) instanceof PlusExpr)
				 {
					 NameExpr nExpr=(NameExpr)paraLHSExpr.getArg(i);
					 aExpr1.setC(0);
					 aExpr1.setVariable(nExpr.getVarName());			
					 PlusExpr pExpr=(PlusExpr)((ParameterizedExpr)RHSExpr).getArg(i);
					 aExpr2.setVariable(pExpr.getLHS().getVarName());			
					 if(pExpr.getRHS() instanceof IntLiteralExpr)			
					 {
						 IntLiteralExpr iExpr=(IntLiteralExpr)pExpr.getRHS();				
						 aExpr2.setC(iExpr.getValue().getValue().intValue());
						 checkDependence(aExpr1,aExpr2,i);
									
					 }//end of nested if	
				 }//end of main if			
				 else if(paraLHSExpr.getArg(i) instanceof NameExpr && ((ParameterizedExpr)RHSExpr).getArg(i) instanceof MinusExpr)
				 {
					 NameExpr nExpr=(NameExpr)paraLHSExpr.getArg(i);
					 aExpr1.setC(0);
					 aExpr1.setVariable(nExpr.getVarName());			
					 MinusExpr mExpr=(MinusExpr)((ParameterizedExpr)RHSExpr).getArg(i);
					 aExpr2.setVariable(mExpr.getLHS().getVarName());			
					 if(mExpr.getRHS() instanceof IntLiteralExpr)			
					 {
						 IntLiteralExpr iExpr=(IntLiteralExpr)mExpr.getRHS();				
						 aExpr2.setC((iExpr.getValue().getValue().intValue())*-1);					
						 checkDependence(aExpr1,aExpr2,i);
					 }//end of nested if	
			}//end of main else if
			
		}//end of for
	}//end of main if
		
}//end of function makeEquationsForSubscriptExprs
	
	
	
	
	/*private void combineEquations(AffineExpression expr1, AffineExpression expr2)
	{
		String t1=expr1.getVariable();
		MinusExpr mExpr = new MinusExpr();
		
		//Setting LHS of Minus Expression.
		NameExpr tNExpr=new NameExpr();
		Name tN=new Name();
		tN.setID(t1);
		tNExpr.setName(tN);
		mExpr.setLHS(tNExpr);
		
		//Setting RHS of Minus Expression.
		IntLiteralExpr iExpr=new IntLiteralExpr();
		//IntNumericLiteralValue iValue=new IntNumericLiteralValue();
		BigInteger bInt=(BigInteger) expr2.getC();
		//iExpr.setValue(new natlab.DecIntNumericLiteralValue(new BigInteger().));
		
		//mExpr.setRHS(new natlab.ast.IntLiteralExpr(new ));
		
		
		
		
	}*/
	
	
	/*
	 * Sets the index of resultArray to false if there is dependence for that particular equation.
	 * If there is no dependence for that equation then sets value true at the location of resultArray.
	 * Size of resultArray depends on the dimensions of the array under dependence testing.
	 */
private void checkDependence(AffineExpression expr1, AffineExpression expr2,int index)
{
		AssignStmt assStmt= forNode.getAssignStmt();//This gives the assignment statement of the loop
		
		if(assStmt.getRHS() instanceof RangeExpr)
		{
			RangeExpr rExpr=(RangeExpr) assStmt.getRHS();
			if(rExpr.getUpper() instanceof IntLiteralExpr)
			{
	    		
				
				IntLiteralExpr iExprUpper=(IntLiteralExpr) rExpr.getUpper();
						
				if(expr2.getC() > (iExprUpper.getValue().getValue().intValue()))
				{
					//System.out.println("There is no dependence");
					resultArray[index]=false;
				//	return true;
				}
				else
					{
					 //System.out.println("There is a dependence in the System");
					 resultArray[index]=true;
					}
				
					
			}
			
			
		}
		
		else if(assStmt.getRHS() instanceof ColonExpr)
		{
			System.out.println("For first loop colon expr");
			
		}
		
		
		
		
}//end of function checkDependence
	
private void reportTestResult(int index)
{
		boolean temp=false;
		for(int i=0;i<index;i++)
		{
			if(resultArray[i]==false)
			{
				System.out.println("There is no dependence for this system of equations");
				temp=true;
				return;
			}
		}
		
		if(!temp)
		{
			System.out.println("There is dependence for this system of equations");
			
		}
		
		
}//end of function reportTestResult
	

}

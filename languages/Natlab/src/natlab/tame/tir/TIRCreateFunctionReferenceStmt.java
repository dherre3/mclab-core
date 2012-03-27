package natlab.tame.tir;

import natlab.tame.tir.analysis.TIRNodeCaseHandler;
import ast.FunctionHandleExpr;
import ast.LambdaExpr;
import ast.Name;
import ast.NameExpr;
import ast.ParameterizedExpr;

public class TIRCreateFunctionReferenceStmt extends
		TIRAbstractCreateFunctionHandleStmt {

    /**
     * creates an asignment of the form
     * lhs = \@function
     */
    public TIRCreateFunctionReferenceStmt(Name lhs,Name function) {
        super(lhs);
        FunctionHandleExpr fHandleExpr = new FunctionHandleExpr(function);
        setRHS(fHandleExpr);
    }
	
    
    /**
     * returns the Name of the function on the rhs
     * @return
     */
    public Name getFunctionName(){
    	return ((FunctionHandleExpr)getRHS()).getName();
    }

    
    
    @Override
    public void irAnalyize(TIRNodeCaseHandler irHandler) {
    	irHandler.caseTIRCreateFunctionReferenceStmt(this);
    }
}

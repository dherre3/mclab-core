// =========================================================================== //
//                                                                             //
// Copyright 2011 Anton Dubrau and McGill University.                          //
//                                                                             //
//   Licensed under the Apache License, Version 2.0 (the "License");           //
//   you may not use this file except in compliance with the License.          //
//   You may obtain a copy of the License at                                   //
//                                                                             //
//       http://www.apache.org/licenses/LICENSE-2.0                            //
//                                                                             //
//   Unless required by applicable law or agreed to in writing, software       //
//   distributed under the License is distributed on an "AS IS" BASIS,         //
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  //
//   See the License for the specific language governing permissions and       //
//  limitations under the License.                                             //
//                                                                             //
// =========================================================================== //

package natlab.Static.ir;

import natlab.Static.ir.analysis.IRNodeCaseHandler;
import ast.*;

/**
 * statements of the form
 * 
 * v(i1,i2,i3,..,in) = t
 * 
 * where v is an array
 * @author ant6n
 */


public class IRArraySetStmt extends IRAbstractAssignStmt {
    private static final long serialVersionUID = 1L;

    public IRArraySetStmt(Name array, IRCommaSeparatedList indizes,Name rhs){
        super();
        setLHS(new ParameterizedExpr(new NameExpr(array),indizes));
        setRHS(new NameExpr(rhs));
    }
    
    public Name getArrayName(){
        return ((NameExpr)((ParameterizedExpr)getLHS()).getTarget()).getName();
    }
        
    
    @Override
    public void irAnalyize(IRNodeCaseHandler irHandler) {
        irHandler.caseIRArraySetStmt(this);
    }

}

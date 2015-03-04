package natlab.toolkits;

import java.util.HashSet;

import natlab.toolkits.path.BuiltinQuery;

public class BuiltinSet {

	private static HashSet<String> builtinSet = new HashSet<String>();

	static {

		builtinSet.add("pi");
		builtinSet.add("i");
		builtinSet.add("j");
		builtinSet.add("tril");
		builtinSet.add("triu");
		builtinSet.add("diag");
		builtinSet.add("real");
		builtinSet.add("imag");
		builtinSet.add("abs");
		builtinSet.add("conj");
		builtinSet.add("sign");
		builtinSet.add("uplus");
		builtinSet.add("uminus");
		builtinSet.add("fix");
		builtinSet.add("round");
		builtinSet.add("floor");
		builtinSet.add("ceil");
		builtinSet.add("complex");
		builtinSet.add("plus");
		builtinSet.add("minus");
		builtinSet.add("times");
		builtinSet.add("power");
		builtinSet.add("ldivide");
		builtinSet.add("rdivide");
		builtinSet.add("mod");
		builtinSet.add("rem");
		builtinSet.add("cross");
		builtinSet.add("mtimes");
		builtinSet.add("mpower");
		builtinSet.add("mldivide");
		builtinSet.add("mrdivide");
		builtinSet.add("dot");
		builtinSet.add("min");
		builtinSet.add("max");
		builtinSet.add("median");
		builtinSet.add("sqrt");
		builtinSet.add("realsqrt");
		builtinSet.add("erf");
		builtinSet.add("erfinv");
		builtinSet.add("erfc");
		builtinSet.add("erfcinv");
		builtinSet.add("gamma");
		builtinSet.add("gammaln");
		builtinSet.add("exp");
		builtinSet.add("log");
		builtinSet.add("log2");
		builtinSet.add("log10");
		builtinSet.add("sin");
		builtinSet.add("cos");
		builtinSet.add("tan");
		builtinSet.add("cot");
		builtinSet.add("sec");
		builtinSet.add("csc");
		builtinSet.add("sind");
		builtinSet.add("cosd");
		builtinSet.add("tand");
		builtinSet.add("cotd");
		builtinSet.add("secd");
		builtinSet.add("cscd");
		builtinSet.add("sinh");
		builtinSet.add("cosh");
		builtinSet.add("tanh");
		builtinSet.add("coth");
		builtinSet.add("sech");
		builtinSet.add("csch");
		builtinSet.add("asin");
		builtinSet.add("acos");
		builtinSet.add("atan");
		builtinSet.add("acot");
		builtinSet.add("asec");
		builtinSet.add("acsc");
		builtinSet.add("asind");
		builtinSet.add("acosd");
		builtinSet.add("atand");
		builtinSet.add("acotd");
		builtinSet.add("asecd");
		builtinSet.add("acscd");
		builtinSet.add("asinh");
		builtinSet.add("acosh");
		builtinSet.add("atanh");
		builtinSet.add("acoth");
		builtinSet.add("asech");
		builtinSet.add("acsch");
		builtinSet.add("logm");
		builtinSet.add("sqrtm");
		builtinSet.add("expm");
		builtinSet.add("inv");
		builtinSet.add("atan2");
		builtinSet.add("hypot");
		builtinSet.add("eps");
		builtinSet.add("cumsum");
		builtinSet.add("cumprod");
		builtinSet.add("mode");
		builtinSet.add("prod");
		builtinSet.add("sum");
		builtinSet.add("mean");
		builtinSet.add("eig");
		builtinSet.add("norm");
		builtinSet.add("rank");
		builtinSet.add("cond");
		builtinSet.add("det");
		builtinSet.add("rcond");
		builtinSet.add("linsolve");
		builtinSet.add("schur");
		builtinSet.add("ordschur");
		builtinSet.add("lu");
		builtinSet.add("chol");
		builtinSet.add("svd");
		builtinSet.add("qr");
		builtinSet.add("bitand");
		builtinSet.add("bitor");
		builtinSet.add("bitxor");
		builtinSet.add("bitcmp");
		builtinSet.add("bitset");
		builtinSet.add("bitget");
		builtinSet.add("bitshift");
		builtinSet.add("find");
		builtinSet.add("nnz");
		builtinSet.add("not");
		builtinSet.add("any");
		builtinSet.add("all");
		builtinSet.add("isreal");
		builtinSet.add("isinf");
		builtinSet.add("isfinite");
		builtinSet.add("isnan");
		builtinSet.add("eq");
		builtinSet.add("ne");
		builtinSet.add("lt");
		builtinSet.add("gt");
		builtinSet.add("le");
		builtinSet.add("ge");
		builtinSet.add("and");
		builtinSet.add("or");
		builtinSet.add("xor");
		builtinSet.add("colon");
		builtinSet.add("ones");
		builtinSet.add("zeros");
		builtinSet.add("magic");
		builtinSet.add("eye");
		builtinSet.add("inf");
		builtinSet.add("nan");
		builtinSet.add("true");
		builtinSet.add("false");
		builtinSet.add("double");
		builtinSet.add("single");
		builtinSet.add("char");
		builtinSet.add("logical");
		builtinSet.add("int8");
		builtinSet.add("int16");
		builtinSet.add("int32");
		builtinSet.add("int64");
		builtinSet.add("uint8");
		builtinSet.add("uint16");
		builtinSet.add("uint32");
		builtinSet.add("uint64");
		builtinSet.add("cell");
		builtinSet.add("cellhorzcat");
		builtinSet.add("cellvertcat");
		builtinSet.add("isfield");
		builtinSet.add("struct");
		builtinSet.add("objectFunction");
		builtinSet.add("sort");
		builtinSet.add("unique");
		builtinSet.add("upper");
		builtinSet.add("lower");
		builtinSet.add("deblank");
		builtinSet.add("strtrim");
		builtinSet.add("strfind");
		builtinSet.add("findstr");
		builtinSet.add("strrep");
		builtinSet.add("strcmp");
		builtinSet.add("strcmpi");
		builtinSet.add("strncmpi");
		builtinSet.add("strncmp");
		builtinSet.add("regexptranslate");
		builtinSet.add("regexp");
		builtinSet.add("regexpi");
		builtinSet.add("regexprep");
		builtinSet.add("class");
		builtinSet.add("size");
		builtinSet.add("length");
		builtinSet.add("ndims");
		builtinSet.add("numel");
		builtinSet.add("end");
		builtinSet.add("isobject");
		builtinSet.add("isfloat");
		builtinSet.add("isinteger");
		builtinSet.add("islogical");
		builtinSet.add("isstruct");
		builtinSet.add("ischar");
		builtinSet.add("iscell");
		builtinSet.add("isnumeric");
		builtinSet.add("isa");
		builtinSet.add("isempty");
		builtinSet.add("isvector");
		builtinSet.add("isscalar");
		builtinSet.add("isequalwithequalnans");
		builtinSet.add("isequal");
		builtinSet.add("reshape");
		builtinSet.add("permute");
		builtinSet.add("squeeze");
		builtinSet.add("transpose");
		builtinSet.add("ctranspose");
		builtinSet.add("horzcat");
		builtinSet.add("vertcat");
		builtinSet.add("cat");
		builtinSet.add("subsasgn");
		builtinSet.add("subsref");
		builtinSet.add("structfun");
		builtinSet.add("arrayfun");
		builtinSet.add("cellfun");
		builtinSet.add("superiorto");
		builtinSet.add("superiorfloat");
		builtinSet.add("exit");
		builtinSet.add("quit");
		builtinSet.add("clock");
		builtinSet.add("tic");
		builtinSet.add("toc");
		builtinSet.add("cputime");
		builtinSet.add("assert");
		builtinSet.add("nargoutchk");
		builtinSet.add("nargchk");
		builtinSet.add("str2func");
		builtinSet.add("pause");
		builtinSet.add("eval");
		builtinSet.add("evalin");
		builtinSet.add("feval");
		builtinSet.add("assignin");
		builtinSet.add("inputname");
		builtinSet.add("import");
		builtinSet.add("cd");
		builtinSet.add("exist");
		builtinSet.add("matlabroot");
		builtinSet.add("whos");
		builtinSet.add("which");
		builtinSet.add("version");
		builtinSet.add("clear");
		builtinSet.add("nargin");
		builtinSet.add("nargout");
		builtinSet.add("methods");
		builtinSet.add("fieldnames");
		builtinSet.add("disp");
		builtinSet.add("display");
		builtinSet.add("clc");
		builtinSet.add("error");
		builtinSet.add("warning");
		builtinSet.add("echo");
		builtinSet.add("diary");
		builtinSet.add("message");
		builtinSet.add("lastwarn");
		builtinSet.add("lasterror");
		builtinSet.add("format");
		builtinSet.add("rand");
		builtinSet.add("randn");
		builtinSet.add("randi");
		builtinSet.add("randperm");
		builtinSet.add("computer");
		builtinSet.add("beep");
		builtinSet.add("dir");
		builtinSet.add("unix");
		builtinSet.add("dos");
		builtinSet.add("system");
		builtinSet.add("load");
		builtinSet.add("save");
		builtinSet.add("input");
		builtinSet.add("textscan");
		builtinSet.add("sprintf");
		builtinSet.add("sscanf");
		builtinSet.add("fprintf");
		builtinSet.add("ftell");
		builtinSet.add("ferror");
		builtinSet.add("fopen");
		builtinSet.add("fread");
		builtinSet.add("frewind");
		builtinSet.add("fscanf");
		builtinSet.add("fseek");
		builtinSet.add("fwrite");
		builtinSet.add("fgetl");
		builtinSet.add("fgets");
		builtinSet.add("fclose");
		builtinSet.add("imwrite");
		builtinSet.add("sparse");
		builtinSet.add("realmax");
		builtinSet.add("histc");
		builtinSet.add("blkdiag");
		builtinSet.add("var");
		builtinSet.add("std");
	}

	public static boolean isBuiltin(String funcName) {
		return builtinSet.contains(funcName);
	}
	
	public static BuiltinQuery getBuiltinQuery() {
		return new BuiltinQuery(){
            public boolean isBuiltin(String functionname) 
              { return builtinSet.contains(functionname); }
        };
		
	}
}

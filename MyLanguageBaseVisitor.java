// MyLanguageVisitor.java

import java.io.FileWriter;
import java.io.IOException;

public class MyLanguageVisitor extends MyLanguageBaseVisitor<Void> {
    private int labelCount = 0;
    private StringBuilder llvmCode = new StringBuilder();

    @Override
    public Void visitIfStatement(MyLanguageParser.IfStatementContext ctx) {
        llvmCode.append("; IF statement\n");
        visit(ctx.expression());

        int thenLabel = labelCount++;
        int endLabel = labelCount++;

        llvmCode.append("br i1 %evalResult, label %then").append(thenLabel)
                .append(", label %end").append(endLabel).append("\n");

        llvmCode.append("then").append(thenLabel).append(":\n");
        visit(ctx.statement(0));

        llvmCode.append("br label %end").append(endLabel).append("\n");

        llvmCode.append("end").append(endLabel).append(":\n");

        return null;
    }

    @Override
    public Void visitPrintStatement(MyLanguageParser.PrintStatementContext ctx) {
        llvmCode.append("; PRINT statement\n");
        visit(ctx.expression());

        llvmCode.append("call void @printInt(i32 %evalResult)\n");

        return null;
    }

    @Override
    public Void visitAssignStatement(MyLanguageParser.AssignStatementContext ctx) {
        llvmCode.append("; ASSIGN statement\n");
        String variable = ctx.VARIABLE().getText();
        String expression = ctx.expression().getText();

        visit(ctx.expression());

        llvmCode.append("%").append(variable).append(" = alloca i32\n");
        llvmCode.append("store i32 %evalResult, i32* %").append(variable).append("\n");

        return null;
    }

    @Override
    public Void visitNumber(MyLanguageParser.NumberContext ctx) {
        int value = Integer.parseInt(ctx.getText());
        llvmCode.append("%evalResult = add i32 0, ").append(value).append("\n");

        return null;
    }

    @Override
    public Void visitVariable(MyLanguageParser.VariableContext ctx) {
        String variable = ctx.getText();
        llvmCode.append("%evalResult = load i32, i32* %").append(variable).append("\n");

        return null;
    }

    @Override
    public Void visitOperator(MyLanguageParser.OperatorContext ctx) {
        String operator = ctx.getText();
        llvmCode.append("; Operator: ").append(operator).append("\n");

        return null;
    }

    @Override
    public Void visitProgram(MyLanguageParser.ProgramContext ctx) {
        llvmCode.append("declare void @printInt(i32)\n");

        return super.visitProgram(ctx);
    }

    void test() {
        try (FileWriter writer = new FileWriter("test.ll")) {
            writer.write(llvmCode.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


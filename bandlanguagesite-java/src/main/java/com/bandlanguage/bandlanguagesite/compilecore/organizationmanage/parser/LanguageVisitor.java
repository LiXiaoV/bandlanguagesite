// Generated from /Users/xiaov/IdeaProjects/bandlanguagesite/bandlanguagesite-java/src/main/java/com/bandlanguage/bandlanguagesite/compilecore/organizationmanage/parser/Language.g4 by ANTLR 4.9.1
package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LanguageParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(LanguageParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(LanguageParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#simpleStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStmt(LanguageParser.SimpleStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#complexStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexStmt(LanguageParser.ComplexStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#subject_predicate_object_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubject_predicate_object_stmt(LanguageParser.Subject_predicate_object_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#subject_predicate_attribute_object_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubject_predicate_attribute_object_stmt(LanguageParser.Subject_predicate_attribute_object_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#subject_adverbial_predicate_attribute_object_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubject_adverbial_predicate_attribute_object_stmt(LanguageParser.Subject_adverbial_predicate_attribute_object_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#subject_adverbial_predicate_complement_attribute_object_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubject_adverbial_predicate_complement_attribute_object_stmt(LanguageParser.Subject_adverbial_predicate_complement_attribute_object_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(LanguageParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#concurrentStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcurrentStmt(LanguageParser.ConcurrentStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#judgeStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJudgeStmt(LanguageParser.JudgeStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#subject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubject(LanguageParser.SubjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(LanguageParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(LanguageParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(LanguageParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#adverbial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdverbial(LanguageParser.AdverbialContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#complement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplement(LanguageParser.ComplementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#place_adverbial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlace_adverbial(LanguageParser.Place_adverbialContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#preposition_object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreposition_object(LanguageParser.Preposition_objectContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#isExist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsExist(LanguageParser.IsExistContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#notExist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExist(LanguageParser.NotExistContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#time_complement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime_complement(LanguageParser.Time_complementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(LanguageParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#logic_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_operator(LanguageParser.Logic_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#noun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoun(LanguageParser.NounContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#verb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerb(LanguageParser.VerbContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#adjective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdjective(LanguageParser.AdjectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#preposition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreposition(LanguageParser.PrepositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#direction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirection(LanguageParser.DirectionContext ctx);
}
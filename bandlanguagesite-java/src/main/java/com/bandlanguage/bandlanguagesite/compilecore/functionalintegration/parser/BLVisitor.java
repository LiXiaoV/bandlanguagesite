package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.parser;// Generated from BL.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BLParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(BLParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(BLParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#complexStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexStmt(BLParser.ComplexStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#simpleStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStmt(BLParser.SimpleStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#runToolStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRunToolStmt(BLParser.RunToolStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#setStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetStmt(BLParser.SetStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#sortStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSortStmt(BLParser.SortStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#groupStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupStmt(BLParser.GroupStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#baStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaStmt(BLParser.BaStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#newObj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewObj(BLParser.NewObjContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#predicate_adverbial_attribute_object_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate_adverbial_attribute_object_stmt(BLParser.Predicate_adverbial_attribute_object_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#predicate_adverbial_object_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate_adverbial_object_stmt(BLParser.Predicate_adverbial_object_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#predicate_attribute_object_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate_attribute_object_stmt(BLParser.Predicate_attribute_object_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#subject_predicate_object_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubject_predicate_object_stmt(BLParser.Subject_predicate_object_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#predicate_object_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate_object_stmt(BLParser.Predicate_object_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#compare_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare_stmt(BLParser.Compare_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(BLParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#subject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubject(BLParser.SubjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(BLParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#object_split}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject_split(BLParser.Object_splitContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#object_single}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject_single(BLParser.Object_singleContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(BLParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(BLParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#adverbial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdverbial(BLParser.AdverbialContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#place_adverbial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlace_adverbial(BLParser.Place_adverbialContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#time_adverbial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime_adverbial(BLParser.Time_adverbialContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#common_adverbial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommon_adverbial(BLParser.Common_adverbialContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#noun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoun(BLParser.NounContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#verb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerb(BLParser.VerbContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#adjective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdjective(BLParser.AdjectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#numerals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerals(BLParser.NumeralsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#quantifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifiers(BLParser.QuantifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(BLParser.TimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#compareWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareWord(BLParser.CompareWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link BLParser#sort}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSort(BLParser.SortContext ctx);
}
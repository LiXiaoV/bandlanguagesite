// Generated from /Users/xiaov/IdeaProjects/bandlanguagesite/bandlanguagesite-java/src/main/java/com/bandlanguage/bandlanguagesite/compilecore/papersanalysis/parser/Language.g4 by ANTLR 4.9.1
package com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.parser;
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
	 * Visit a parse tree produced by {@link LanguageParser#subject_predicate_object_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubject_predicate_object_stmt(LanguageParser.Subject_predicate_object_stmtContext ctx);
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
}
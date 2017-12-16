package it.sevenbits.formatter.implementation.statemachine;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.command.defaultState.CloseBracketCommand;
import it.sevenbits.formatter.implementation.statemachine.command.newLineState.CharNewLineCommand;
import it.sevenbits.formatter.implementation.statemachine.command.newLineState.CloseBracketNewLineCommand;
import it.sevenbits.formatter.implementation.statemachine.command.defaultState.DefaultCommand;
import it.sevenbits.formatter.implementation.statemachine.command.defaultState.OpenBracketCommand;
import it.sevenbits.formatter.implementation.statemachine.command.newLineState.NewLineNewLineCommand;
import it.sevenbits.formatter.implementation.statemachine.command.newLineState.OpenBracketNewLineCommand;
import it.sevenbits.formatter.implementation.statemachine.command.defaultState.SemicolonCommand;
import it.sevenbits.formatter.implementation.statemachine.command.NopeCommand;
import it.sevenbits.formatter.implementation.statemachine.command.newLineState.SemicolonNewLineCommand;
import it.sevenbits.formatter.implementation.statemachine.core.ICommand;
import it.sevenbits.formatter.implementation.statemachine.core.ICommandRepository;
import it.sevenbits.formatter.implementation.statemachine.core.IState;

import java.util.HashMap;

/**
 * CommandRepository class.
 */
public class CommandRepository implements ICommandRepository {

    private HashMap<Pair, ICommand> map;

    /**
     * Constructor command repository.
     */
    public CommandRepository() {

        //Default state.
        Pair<State, String> pairDefaultSimpleChar = new Pair<>(new State("DefaultState"), "Char");
        Pair<State, String> pairDefaultOpenBracket = new Pair<>(new State("DefaultState"), "OpenBracket");
        Pair<State, String> pairDefaultCloseBracket = new Pair<>(new State("DefaultState"), "CloseBracket");
        Pair<State, String> pairDefaultSemicolon = new Pair<>(new State("DefaultState"), "Semicolon");
        Pair<State, String> pairDefaultSpace = new Pair<>(new State("DefaultState"), "Space");
        Pair<State, String> pairDefaultNewLine = new Pair<>(new State("DefaultState"), "NewLine");
        Pair<State, String> pairDefaultStringLiteral = new Pair<>(new State("DefaultState"), "StringLiteral");
        Pair<State, String> pairDefaultSingleLineComment = new Pair<>(new State("DefaultState"), "SingleLineComment");
        Pair<State, String> pairDefaultOpenMultiLineComment = new Pair<>(new State("DefaultState"), "OpenMultiLineComment");
        Pair<State, String> pairDefaultCloseMultiLineComment = new Pair<>(new State("DefaultState"), "CloseMultiLineComment");

        //NewLine state.
        Pair<State, String> pairNewLineSimpleChar = new Pair<>(new State("NewLineState"), "Char");
        Pair<State, String> pairNewLineOpenBracket = new Pair<>(new State("NewLineState"), "OpenBracket");
        Pair<State, String> pairNewLineCloseBracket = new Pair<>(new State("NewLineState"), "CloseBracket");
        Pair<State, String> pairNewLineSemicolon = new Pair<>(new State("NewLineState"), "Semicolon");
        Pair<State, String> pairNewLineSpace = new Pair<>(new State("NewLineState"), "Space");
        Pair<State, String> pairNewLineNewLine = new Pair<>(new State("NewLineState"), "NewLine");
        Pair<State, String> pairNewLineStringLiteral = new Pair<>(new State("NewLineState"), "StringLiteral");
        Pair<State, String> pairNewLineSingleLineComment = new Pair<>(new State("NewLineState"), "SingleLineComment");
        Pair<State, String> pairNewLineOpenMultiLineComment = new Pair<>(new State("NewLinetState"), "OpenMultiLineComment");
        Pair<State, String> pairNewLineCloseMultiLineComment = new Pair<>(new State("NewLineState"), "CloseMultiLineComment");

        //StringLiteralState
        Pair<State, String> pairStringLiteralSimpleChar = new Pair<>(new State("StringLiteralState"), "Char");
        Pair<State, String> pairStringLiteralOpenBracket = new Pair<>(new State("StringLiteralState"), "OpenBracket");
        Pair<State, String> pairStringLiteralCloseBracket = new Pair<>(new State("StringLiteralState"), "CloseBracket");
        Pair<State, String> pairStringLiteralSemicolon = new Pair<>(new State("StringLiteralState"), "Semicolon");
        Pair<State, String> pairStringLiteralSpace = new Pair<>(new State("StringLiteralState"), "Space");
        Pair<State, String> pairStringLiteralNewLine = new Pair<>(new State("StringLiteralState"), "NewLine");
        Pair<State, String> pairStringLiteralStringLiteral = new Pair<>(new State("StringLiteralState"), "StringLiteral");
        Pair<State, String> pairStringLiteralSingleLineComment = new Pair<>(new State("StringLiteralState"), "SingleLineComment");
        Pair<State, String> pairStringLiteralOpenMultiLineComment = new Pair<>(new State("StringLiteralState"), "OpenMultiLineComment");
        Pair<State, String> pairStringLiteralCloseMultiLineComment = new Pair<>(new State("StringLiteralState"), "CloseMultiLineComment");

        //SingleLineComment
        Pair<State, String> pairSingleLineCommentSimpleChar = new Pair<>(new State("SingleLineCommentState"), "Char");
        Pair<State, String> pairSingleLineCommentOpenBracket = new Pair<>(new State("SingleLineCommentState"), "OpenBracket");
        Pair<State, String> pairSingleLineCommentCloseBracket = new Pair<>(new State("SingleLineCommentState"), "CloseBracket");
        Pair<State, String> pairSingleLineCommentSemicolon = new Pair<>(new State("SingleLineCommentState"), "Semicolon");
        Pair<State, String> pairSingleLineCommentSpace = new Pair<>(new State("SingleLineCommentState"), "Space");
        Pair<State, String> pairSingleLineCommentNewLine = new Pair<>(new State("SingleLineCommentState"), "NewLine");
        Pair<State, String> pairSingleLineCommentStringLiteral = new Pair<>(new State("SingleLineCommentState"), "StringLiteral");
        Pair<State, String> pairSingleLineCommentSingleLineComment = new Pair<>(new State("SingleLineCommentState"), "SingleLineComment");
        Pair<State, String> pairSingleLineCommentOpenMultiLineComment = new Pair<>(new State("SingleLineCommentState"), "OpenMultiLineComment");
        Pair<State, String> pairSingleLineCommentCloseMultiLineComment = new Pair<>(new State("SingleLineCommentState"), "CloseMultiLineComment");

        //MultiLineComment
        Pair<State, String> pairMultiLineCommentSimpleChar = new Pair<>(new State("MultiLineCommentState"), "Char");
        Pair<State, String> pairMultiLineCommentOpenBracket = new Pair<>(new State("MultiLineCommentState"), "OpenBracket");
        Pair<State, String> pairMultiLineCommentCloseBracket = new Pair<>(new State("MultiLineCommentState"), "CloseBracket");
        Pair<State, String> pairMultiLineCommentSemicolon = new Pair<>(new State("MultiLineCommentState"), "Semicolon");
        Pair<State, String> pairMultiLineCommentSpace = new Pair<>(new State("MultiLineCommentState"), "Space");
        Pair<State, String> pairMultiLineCommentNewLine = new Pair<>(new State("MultiLineCommentState"), "NewLine");
        Pair<State, String> pairMultiLineCommentStringLiteral = new Pair<>(new State("MultiLineCommentState"), "StringLiteral");
        Pair<State, String> pairMultiLineCommentSingleLineComment = new Pair<>(new State("MultiLineCommentState"), "SingleLineComment");
        Pair<State, String> pairMultiLineCommentOpenMultiLineComment = new Pair<>(new State("MultiLineCommentState"), "OpenMultiLineComment");
        Pair<State, String> pairMultiLineCommentCloseMultiLineComment = new Pair<>(new State("MultiLineCommentState"), "CloseMultiLineComment");


        map = new HashMap<>();

        //Default state.
        map.put(pairDefaultSimpleChar, new DefaultCommand());
        map.put(pairDefaultOpenBracket, new OpenBracketCommand());
        map.put(pairDefaultCloseBracket, new CloseBracketCommand());
        map.put(pairDefaultSemicolon, new SemicolonCommand());
        map.put(pairDefaultSpace, new DefaultCommand());
        map.put(pairDefaultNewLine, new NopeCommand());
        map.put(pairDefaultStringLiteral, new DefaultCommand());
        map.put(pairDefaultSingleLineComment, new DefaultCommand());
        map.put(pairDefaultOpenMultiLineComment, new DefaultCommand());
        map.put(pairDefaultCloseMultiLineComment, new DefaultCommand());

        //NewLine state.
        map.put(pairNewLineSimpleChar, new CharNewLineCommand());
        map.put(pairNewLineOpenBracket, new OpenBracketNewLineCommand());
        map.put(pairNewLineCloseBracket, new CloseBracketNewLineCommand());
        map.put(pairNewLineSemicolon, new SemicolonNewLineCommand());
        map.put(pairNewLineSpace, new NopeCommand());
        map.put(pairNewLineNewLine, new NewLineNewLineCommand());
        map.put(pairNewLineStringLiteral, new CharNewLineCommand());
        map.put(pairNewLineSingleLineComment, new CharNewLineCommand());
        map.put(pairNewLineOpenMultiLineComment, new CharNewLineCommand());
        map.put(pairNewLineCloseMultiLineComment, new CharNewLineCommand());

        //SingleLineComment state.
        map.put(pairSingleLineCommentSimpleChar, new DefaultCommand());
        map.put(pairSingleLineCommentOpenBracket, new DefaultCommand());
        map.put(pairSingleLineCommentCloseBracket, new DefaultCommand());
        map.put(pairSingleLineCommentSemicolon, new DefaultCommand());
        map.put(pairSingleLineCommentSpace, new DefaultCommand());
        map.put(pairSingleLineCommentNewLine, new NopeCommand());
        map.put(pairSingleLineCommentStringLiteral, new DefaultCommand());
        map.put(pairSingleLineCommentSingleLineComment, new DefaultCommand());
        map.put(pairSingleLineCommentOpenMultiLineComment, new DefaultCommand());
        map.put(pairSingleLineCommentCloseMultiLineComment, new DefaultCommand());

        //StringLiteral state.
        map.put(pairStringLiteralSimpleChar, new DefaultCommand());
        map.put(pairStringLiteralOpenBracket, new DefaultCommand());
        map.put(pairStringLiteralCloseBracket, new DefaultCommand());
        map.put(pairStringLiteralSemicolon, new DefaultCommand());
        map.put(pairStringLiteralSpace, new DefaultCommand());
        map.put(pairStringLiteralNewLine, new DefaultCommand());
        map.put(pairStringLiteralStringLiteral, new DefaultCommand());
        map.put(pairStringLiteralSingleLineComment, new DefaultCommand());
        map.put(pairStringLiteralOpenMultiLineComment, new DefaultCommand());
        map.put(pairStringLiteralCloseMultiLineComment, new DefaultCommand());

        //MultiLineComment state.
        map.put(pairMultiLineCommentSimpleChar, new DefaultCommand());
        map.put(pairMultiLineCommentOpenBracket, new DefaultCommand());
        map.put(pairMultiLineCommentCloseBracket, new DefaultCommand());
        map.put(pairMultiLineCommentSemicolon, new DefaultCommand());
        map.put(pairMultiLineCommentSpace, new DefaultCommand());
        map.put(pairMultiLineCommentNewLine, new DefaultCommand());
        map.put(pairMultiLineCommentStringLiteral, new DefaultCommand());
        map.put(pairMultiLineCommentSingleLineComment, new DefaultCommand());
        map.put(pairMultiLineCommentOpenMultiLineComment, new DefaultCommand());
        map.put(pairMultiLineCommentCloseMultiLineComment, new DefaultCommand());
    }


    @Override
    public ICommand getCommand(final IState state, final IToken token) {
        Pair currentPair = new Pair<>(state, token.getName());
        return map.get(currentPair);
    }
}

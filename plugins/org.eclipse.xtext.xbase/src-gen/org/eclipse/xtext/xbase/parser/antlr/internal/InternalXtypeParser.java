package org.eclipse.xtext.xbase.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalXtypeParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'('", "','", "')'", "'=>'", "'<'", "'>'", "'.'", "'?'", "'extends'", "'&'", "'super'", "'*'", "'import'", "'static'", "'extension'", "';'"
    };
    public static final int RULE_ID=4;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=9;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=7;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=6;
    public static final int T__19=19;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int RULE_WS=8;

    // delegates
    // delegators


        public InternalXtypeParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXtypeParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXtypeParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g"; }



     	private XtypeGrammarAccess grammarAccess;
     	
        public InternalXtypeParser(TokenStream input, XtypeGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "JvmTypeReference";	
       	}
       	
       	@Override
       	protected XtypeGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleJvmTypeReference"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:67:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:68:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:69:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference75);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:76:1: ruleJvmTypeReference returns [EObject current=null] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:79:28: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:80:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:80:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==12||LA2_0==15) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:80:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:80:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:81:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference133);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmParameterizedTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:89:1: ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==10) && (synpred1_InternalXtype())) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:89:2: ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:90:24: ( () ruleArrayBrackets )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:90:25: () ruleArrayBrackets
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:90:25: ()
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:91:5: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	              current = forceCreateModelElementAndSet(
                    	                  grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(),
                    	                  current);
                    	          
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	       
                    	              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1()); 
                    	          
                    	    }
                    	    pushFollow(FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference169);
                    	    ruleArrayBrackets();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	              afterParserOrEnumRuleCall();
                    	          
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:106:5: this_XFunctionTypeRef_3= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference200);
                    this_XFunctionTypeRef_3=ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFunctionTypeRef_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleArrayBrackets"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:122:1: entryRuleArrayBrackets returns [String current=null] : iv_ruleArrayBrackets= ruleArrayBrackets EOF ;
    public final String entryRuleArrayBrackets() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArrayBrackets = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:123:2: (iv_ruleArrayBrackets= ruleArrayBrackets EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:124:2: iv_ruleArrayBrackets= ruleArrayBrackets EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayBracketsRule()); 
            }
            pushFollow(FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets236);
            iv_ruleArrayBrackets=ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayBrackets.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayBrackets247); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayBrackets"


    // $ANTLR start "ruleArrayBrackets"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:131:1: ruleArrayBrackets returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '[' kw= ']' ) ;
    public final AntlrDatatypeRuleToken ruleArrayBrackets() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:134:28: ( (kw= '[' kw= ']' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:135:1: (kw= '[' kw= ']' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:135:1: (kw= '[' kw= ']' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:136:2: kw= '[' kw= ']'
            {
            kw=(Token)match(input,10,FOLLOW_10_in_ruleArrayBrackets285); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0()); 
                  
            }
            kw=(Token)match(input,11,FOLLOW_11_in_ruleArrayBrackets298); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayBrackets"


    // $ANTLR start "entryRuleXFunctionTypeRef"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:155:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:156:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:157:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef338);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef348); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXFunctionTypeRef"


    // $ANTLR start "ruleXFunctionTypeRef"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:164:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_paramTypes_1_0 = null;

        EObject lv_paramTypes_3_0 = null;

        EObject lv_returnType_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:167:28: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:168:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:168:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:168:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:168:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:168:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleXFunctionTypeRef386); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:172:1: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID||LA4_0==12||LA4_0==15) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:172:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:172:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:173:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:173:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:174:3: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef408);
                            lv_paramTypes_1_0=ruleJvmTypeReference();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"paramTypes",
                                      		lv_paramTypes_1_0, 
                                      		"JvmTypeReference");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:190:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:190:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleXFunctionTypeRef421); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:194:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:195:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:195:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:196:3: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef442);
                            	    lv_paramTypes_3_0=ruleJvmTypeReference();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"paramTypes",
                            	              		lv_paramTypes_3_0, 
                            	              		"JvmTypeReference");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop3;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleXFunctionTypeRef458); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleXFunctionTypeRef472); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:220:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:221:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:221:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:222:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef493);
            lv_returnType_6_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
              	        }
                     		set(
                     			current, 
                     			"returnType",
                      		lv_returnType_6_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXFunctionTypeRef"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:246:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:247:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:248:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference529);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference539); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmParameterizedTypeReference"


    // $ANTLR start "ruleJvmParameterizedTypeReference"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:255:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;

        EObject lv_arguments_10_0 = null;

        EObject lv_arguments_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:258:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:259:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:259:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:259:2: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:259:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:260:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:260:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:261:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference587);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:274:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==16) && (synpred2_InternalXtype())) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:274:3: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:274:3: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:274:4: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleJvmParameterizedTypeReference608); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:279:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:280:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:280:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:281:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference630);
                    lv_arguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_2_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:297:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==13) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:297:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleJvmParameterizedTypeReference643); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:301:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:302:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:302:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:303:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference664);
                    	    lv_arguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"arguments",
                    	              		lv_arguments_4_0, 
                    	              		"JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleJvmParameterizedTypeReference678); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:323:1: ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==18) && (synpred3_InternalXtype())) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:323:2: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:323:2: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:323:3: ( ( () '.' ) )=> ( () otherlv_7= '.' )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:325:5: ( () otherlv_7= '.' )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:325:6: () otherlv_7= '.'
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:325:6: ()
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:326:5: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	              current = forceCreateModelElementAndSet(
                    	                  grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0(),
                    	                  current);
                    	          
                    	    }

                    	    }

                    	    otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleJvmParameterizedTypeReference714); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_7, grammarAccess.getJvmParameterizedTypeReferenceAccess().getFullStopKeyword_1_4_0_0_1());
                    	          
                    	    }

                    	    }


                    	    }

                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:335:3: ( ( ruleValidID ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:336:1: ( ruleValidID )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:336:1: ( ruleValidID )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:337:3: ruleValidID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_1_4_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleValidID_in_ruleJvmParameterizedTypeReference739);
                    	    ruleValidID();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:350:2: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    int alt8=2;
                    	    int LA8_0 = input.LA(1);

                    	    if ( (LA8_0==16) && (synpred4_InternalXtype())) {
                    	        alt8=1;
                    	    }
                    	    switch (alt8) {
                    	        case 1 :
                    	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:350:3: ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>'
                    	            {
                    	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:350:3: ( ( '<' )=>otherlv_9= '<' )
                    	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:350:4: ( '<' )=>otherlv_9= '<'
                    	            {
                    	            otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleJvmParameterizedTypeReference760); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                  	newLeafNode(otherlv_9, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_4_2_0());
                    	                  
                    	            }

                    	            }

                    	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:355:2: ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) )
                    	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:356:1: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            {
                    	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:356:1: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:357:3: lv_arguments_10_0= ruleJvmArgumentTypeReference
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0()); 
                    	              	    
                    	            }
                    	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference782);
                    	            lv_arguments_10_0=ruleJvmArgumentTypeReference();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	              	        }
                    	                     		add(
                    	                     			current, 
                    	                     			"arguments",
                    	                      		lv_arguments_10_0, 
                    	                      		"JvmArgumentTypeReference");
                    	              	        afterParserOrEnumRuleCall();
                    	              	    
                    	            }

                    	            }


                    	            }

                    	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:373:2: (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )*
                    	            loop7:
                    	            do {
                    	                int alt7=2;
                    	                int LA7_0 = input.LA(1);

                    	                if ( (LA7_0==13) ) {
                    	                    alt7=1;
                    	                }


                    	                switch (alt7) {
                    	            	case 1 :
                    	            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:373:4: otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    {
                    	            	    otherlv_11=(Token)match(input,13,FOLLOW_13_in_ruleJvmParameterizedTypeReference795); if (state.failed) return current;
                    	            	    if ( state.backtracking==0 ) {

                    	            	          	newLeafNode(otherlv_11, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_4_2_2_0());
                    	            	          
                    	            	    }
                    	            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:377:1: ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:378:1: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    {
                    	            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:378:1: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:379:3: lv_arguments_12_0= ruleJvmArgumentTypeReference
                    	            	    {
                    	            	    if ( state.backtracking==0 ) {
                    	            	       
                    	            	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0()); 
                    	            	      	    
                    	            	    }
                    	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference816);
                    	            	    lv_arguments_12_0=ruleJvmArgumentTypeReference();

                    	            	    state._fsp--;
                    	            	    if (state.failed) return current;
                    	            	    if ( state.backtracking==0 ) {

                    	            	      	        if (current==null) {
                    	            	      	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	            	      	        }
                    	            	             		add(
                    	            	             			current, 
                    	            	             			"arguments",
                    	            	              		lv_arguments_12_0, 
                    	            	              		"JvmArgumentTypeReference");
                    	            	      	        afterParserOrEnumRuleCall();
                    	            	      	    
                    	            	    }

                    	            	    }


                    	            	    }


                    	            	    }
                    	            	    break;

                    	            	default :
                    	            	    break loop7;
                    	                }
                    	            } while (true);

                    	            otherlv_13=(Token)match(input,17,FOLLOW_17_in_ruleJvmParameterizedTypeReference830); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                  	newLeafNode(otherlv_13, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_4_2_3());
                    	                  
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmParameterizedTypeReference"


    // $ANTLR start "entryRuleJvmArgumentTypeReference"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:407:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:408:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:409:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference872);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference882); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmArgumentTypeReference"


    // $ANTLR start "ruleJvmArgumentTypeReference"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:416:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:419:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:420:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:420:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID||LA11_0==12||LA11_0==15) ) {
                alt11=1;
            }
            else if ( (LA11_0==19) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:421:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference929);
                    this_JvmTypeReference_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:431:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference956);
                    this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmWildcardTypeReference_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmArgumentTypeReference"


    // $ANTLR start "entryRuleJvmWildcardTypeReference"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:447:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:448:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:449:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference991);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference1001); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmWildcardTypeReference"


    // $ANTLR start "ruleJvmWildcardTypeReference"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:456:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;

        EObject lv_constraints_4_0 = null;

        EObject lv_constraints_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:459:28: ( ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:460:1: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:460:1: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:460:2: () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:460:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:461:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleJvmWildcardTypeReference1047); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:470:1: ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==20) ) {
                alt14=1;
            }
            else if ( (LA14_0==22) ) {
                alt14=2;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:470:2: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:470:2: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:470:3: ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:470:3: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:471:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:471:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:472:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference1070);
                    lv_constraints_2_0=ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_2_0, 
                              		"JvmUpperBound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:488:2: ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==21) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:489:1: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:489:1: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:490:3: lv_constraints_3_0= ruleJvmUpperBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmWildcardTypeReference1091);
                    	    lv_constraints_3_0=ruleJvmUpperBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"constraints",
                    	              		lv_constraints_3_0, 
                    	              		"JvmUpperBoundAnded");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:507:6: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:507:6: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:507:7: ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:507:7: ( (lv_constraints_4_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:508:1: (lv_constraints_4_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:508:1: (lv_constraints_4_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:509:3: lv_constraints_4_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference1121);
                    lv_constraints_4_0=ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_4_0, 
                              		"JvmLowerBound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:525:2: ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==21) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:526:1: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:526:1: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:527:3: lv_constraints_5_0= ruleJvmLowerBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmLowerBoundAnded_in_ruleJvmWildcardTypeReference1142);
                    	    lv_constraints_5_0=ruleJvmLowerBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"constraints",
                    	              		lv_constraints_5_0, 
                    	              		"JvmLowerBoundAnded");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmWildcardTypeReference"


    // $ANTLR start "entryRuleJvmUpperBound"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:551:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:552:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:553:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound1182);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound1192); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmUpperBound"


    // $ANTLR start "ruleJvmUpperBound"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:560:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:563:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:564:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:564:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:564:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleJvmUpperBound1229); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:568:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:569:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:569:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:570:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound1250);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmUpperBoundRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmUpperBound"


    // $ANTLR start "entryRuleJvmUpperBoundAnded"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:594:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:595:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:596:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded1286);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded1296); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmUpperBoundAnded"


    // $ANTLR start "ruleJvmUpperBoundAnded"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:603:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:606:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:607:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:607:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:607:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleJvmUpperBoundAnded1333); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:611:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:612:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:612:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:613:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded1354);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmUpperBoundAndedRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmUpperBoundAnded"


    // $ANTLR start "entryRuleJvmLowerBound"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:637:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:638:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:639:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound1390);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound1400); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmLowerBound"


    // $ANTLR start "ruleJvmLowerBound"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:646:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:649:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:650:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:650:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:650:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleJvmLowerBound1437); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:654:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:655:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:655:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:656:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound1458);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmLowerBoundRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmLowerBound"


    // $ANTLR start "entryRuleJvmLowerBoundAnded"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:680:1: entryRuleJvmLowerBoundAnded returns [EObject current=null] : iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF ;
    public final EObject entryRuleJvmLowerBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBoundAnded = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:681:2: (iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:682:2: iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBoundAnded_in_entryRuleJvmLowerBoundAnded1494);
            iv_ruleJvmLowerBoundAnded=ruleJvmLowerBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBoundAnded1504); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmLowerBoundAnded"


    // $ANTLR start "ruleJvmLowerBoundAnded"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:689:1: ruleJvmLowerBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:692:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:693:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:693:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:693:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleJvmLowerBoundAnded1541); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:697:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:698:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:698:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:699:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBoundAnded1562);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmLowerBoundAndedRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmLowerBoundAnded"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:725:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:726:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:727:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1601);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1612); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:734:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:737:28: ( (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:738:1: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:738:1: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:739:5: this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName1659);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:749:1: (kw= '.' this_ValidID_2= ruleValidID )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==18) ) {
                    int LA15_2 = input.LA(2);

                    if ( (LA15_2==RULE_ID) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:750:2: kw= '.' this_ValidID_2= ruleValidID
            	    {
            	    kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedName1678); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName1700);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:774:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:775:2: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:776:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard1748);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildcard.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard1759); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:783:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:786:28: ( (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:787:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:787:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:788:5: this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*'
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard1806);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedNameWithWildcard1824); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopKeyword_1()); 
                  
            }
            kw=(Token)match(input,23,FOLLOW_23_in_ruleQualifiedNameWithWildcard1837); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getAsteriskKeyword_2()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleValidID"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:818:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:819:2: (iv_ruleValidID= ruleValidID EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:820:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID1878);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID1889); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:827:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:830:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:831:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID1928); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleXImportDeclaration"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:848:1: entryRuleXImportDeclaration returns [EObject current=null] : iv_ruleXImportDeclaration= ruleXImportDeclaration EOF ;
    public final EObject entryRuleXImportDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXImportDeclaration = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:849:2: (iv_ruleXImportDeclaration= ruleXImportDeclaration EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:850:2: iv_ruleXImportDeclaration= ruleXImportDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXImportDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration1974);
            iv_ruleXImportDeclaration=ruleXImportDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportDeclaration1984); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXImportDeclaration"


    // $ANTLR start "ruleXImportDeclaration"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:857:1: ruleXImportDeclaration returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) ;
    public final EObject ruleXImportDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token lv_extension_2_0=null;
        Token lv_wildcard_4_0=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_memberName_5_0 = null;

        AntlrDatatypeRuleToken lv_importedNamespace_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:860:28: ( (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:861:1: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:861:1: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:861:3: otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )?
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleXImportDeclaration2021); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXImportDeclarationAccess().getImportKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:865:1: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )
            int alt18=3;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:865:2: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:865:2: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:865:3: ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:865:3: ( (lv_static_1_0= 'static' ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:866:1: (lv_static_1_0= 'static' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:866:1: (lv_static_1_0= 'static' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:867:3: lv_static_1_0= 'static'
                    {
                    lv_static_1_0=(Token)match(input,25,FOLLOW_25_in_ruleXImportDeclaration2041); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_static_1_0, grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXImportDeclarationRule());
                      	        }
                             		setWithLastConsumed(current, "static", true, "static");
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:880:2: ( (lv_extension_2_0= 'extension' ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==26) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:881:1: (lv_extension_2_0= 'extension' )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:881:1: (lv_extension_2_0= 'extension' )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:882:3: lv_extension_2_0= 'extension'
                            {
                            lv_extension_2_0=(Token)match(input,26,FOLLOW_26_in_ruleXImportDeclaration2072); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_extension_2_0, grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getXImportDeclarationRule());
                              	        }
                                     		setWithLastConsumed(current, "extension", true, "extension");
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:895:3: ( ( ruleQualifiedNameInStaticImport ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:896:1: ( ruleQualifiedNameInStaticImport )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:896:1: ( ruleQualifiedNameInStaticImport )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:897:3: ruleQualifiedNameInStaticImport
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXImportDeclarationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedNameInStaticImport_in_ruleXImportDeclaration2109);
                    ruleQualifiedNameInStaticImport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:910:2: ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==23) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==RULE_ID) ) {
                        alt17=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:910:3: ( (lv_wildcard_4_0= '*' ) )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:910:3: ( (lv_wildcard_4_0= '*' ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:911:1: (lv_wildcard_4_0= '*' )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:911:1: (lv_wildcard_4_0= '*' )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:912:3: lv_wildcard_4_0= '*'
                            {
                            lv_wildcard_4_0=(Token)match(input,23,FOLLOW_23_in_ruleXImportDeclaration2128); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_wildcard_4_0, grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getXImportDeclarationRule());
                              	        }
                                     		setWithLastConsumed(current, "wildcard", true, "*");
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:926:6: ( (lv_memberName_5_0= ruleValidID ) )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:926:6: ( (lv_memberName_5_0= ruleValidID ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:927:1: (lv_memberName_5_0= ruleValidID )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:927:1: (lv_memberName_5_0= ruleValidID )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:928:3: lv_memberName_5_0= ruleValidID
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXImportDeclarationAccess().getMemberNameValidIDParserRuleCall_1_0_3_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleValidID_in_ruleXImportDeclaration2168);
                            lv_memberName_5_0=ruleValidID();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXImportDeclarationRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"memberName",
                                      		lv_memberName_5_0, 
                                      		"ValidID");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:945:6: ( ( ruleQualifiedName ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:945:6: ( ( ruleQualifiedName ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:946:1: ( ruleQualifiedName )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:946:1: ( ruleQualifiedName )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:947:3: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXImportDeclarationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration2199);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:961:6: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:961:6: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:962:1: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:962:1: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:963:3: lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleXImportDeclaration2226);
                    lv_importedNamespace_7_0=ruleQualifiedNameWithWildcard();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXImportDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"importedNamespace",
                              		lv_importedNamespace_7_0, 
                              		"QualifiedNameWithWildcard");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:979:3: (otherlv_8= ';' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:979:5: otherlv_8= ';'
                    {
                    otherlv_8=(Token)match(input,27,FOLLOW_27_in_ruleXImportDeclaration2240); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXImportDeclaration"


    // $ANTLR start "entryRuleQualifiedNameInStaticImport"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:991:1: entryRuleQualifiedNameInStaticImport returns [String current=null] : iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF ;
    public final String entryRuleQualifiedNameInStaticImport() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameInStaticImport = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:992:2: (iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:993:2: iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameInStaticImportRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameInStaticImport_in_entryRuleQualifiedNameInStaticImport2279);
            iv_ruleQualifiedNameInStaticImport=ruleQualifiedNameInStaticImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameInStaticImport.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameInStaticImport2290); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameInStaticImport"


    // $ANTLR start "ruleQualifiedNameInStaticImport"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:1000:1: ruleQualifiedNameInStaticImport returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '.' )+ ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameInStaticImport() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:1003:28: ( (this_ValidID_0= ruleValidID kw= '.' )+ )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:1004:1: (this_ValidID_0= ruleValidID kw= '.' )+
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:1004:1: (this_ValidID_0= ruleValidID kw= '.' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    int LA20_2 = input.LA(2);

                    if ( (LA20_2==18) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:1005:5: this_ValidID_0= ruleValidID kw= '.'
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameInStaticImportAccess().getValidIDParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedNameInStaticImport2337);
            	    this_ValidID_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedNameInStaticImport2355); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameInStaticImportAccess().getFullStopKeyword_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameInStaticImport"

    // $ANTLR start synpred1_InternalXtype
    public final void synpred1_InternalXtype_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:89:2: ( ( () ruleArrayBrackets ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:89:3: ( () ruleArrayBrackets )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:89:3: ( () ruleArrayBrackets )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:89:4: () ruleArrayBrackets
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:89:4: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:90:1: 
        {
        }

        pushFollow(FOLLOW_ruleArrayBrackets_in_synpred1_InternalXtype148);
        ruleArrayBrackets();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalXtype

    // $ANTLR start synpred2_InternalXtype
    public final void synpred2_InternalXtype_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:274:4: ( '<' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:274:6: '<'
        {
        match(input,16,FOLLOW_16_in_synpred2_InternalXtype600); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalXtype

    // $ANTLR start synpred3_InternalXtype
    public final void synpred3_InternalXtype_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:323:3: ( ( () '.' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:323:4: ( () '.' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:323:4: ( () '.' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:323:5: () '.'
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:323:5: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:324:1: 
        {
        }

        match(input,18,FOLLOW_18_in_synpred3_InternalXtype695); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalXtype

    // $ANTLR start synpred4_InternalXtype
    public final void synpred4_InternalXtype_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:350:4: ( '<' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXtype.g:350:6: '<'
        {
        match(input,16,FOLLOW_16_in_synpred4_InternalXtype752); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalXtype

    // Delegated rules

    public final boolean synpred4_InternalXtype() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalXtype_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalXtype() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalXtype_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalXtype() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalXtype_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalXtype() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalXtype_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA18_eotS =
        "\7\uffff";
    static final String DFA18_eofS =
        "\2\uffff\1\4\2\uffff\1\4\1\uffff";
    static final String DFA18_minS =
        "\1\4\1\uffff\1\22\1\4\1\uffff\1\22\1\uffff";
    static final String DFA18_maxS =
        "\1\31\1\uffff\1\33\1\27\1\uffff\1\33\1\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\1\uffff\1\3";
    static final String DFA18_specialS =
        "\7\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\2\24\uffff\1\1",
            "",
            "\1\3\10\uffff\1\4",
            "\1\5\22\uffff\1\6",
            "",
            "\1\3\10\uffff\1\4",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "865:1: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference133 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference169 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets236 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayBrackets247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_ruleArrayBrackets285 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleArrayBrackets298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef338 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleXFunctionTypeRef386 = new BitSet(new long[]{0x000000000000D010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef408 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleXFunctionTypeRef421 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef442 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleXFunctionTypeRef458 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleXFunctionTypeRef472 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference529 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference587 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleJvmParameterizedTypeReference608 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference630 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleJvmParameterizedTypeReference643 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference664 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleJvmParameterizedTypeReference678 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleJvmParameterizedTypeReference714 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmParameterizedTypeReference739 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_16_in_ruleJvmParameterizedTypeReference760 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference782 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleJvmParameterizedTypeReference795 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference816 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleJvmParameterizedTypeReference830 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference872 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference991 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleJvmWildcardTypeReference1047 = new BitSet(new long[]{0x0000000000500002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference1070 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmWildcardTypeReference1091 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference1121 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmLowerBoundAnded_in_ruleJvmWildcardTypeReference1142 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound1182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound1192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleJvmUpperBound1229 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded1286 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded1296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleJvmUpperBoundAnded1333 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound1390 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound1400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleJvmLowerBound1437 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound1458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBoundAnded_in_entryRuleJvmLowerBoundAnded1494 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBoundAnded1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleJvmLowerBoundAnded1541 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBoundAnded1562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName1659 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedName1678 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName1700 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard1748 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard1759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard1806 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedNameWithWildcard1824 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleQualifiedNameWithWildcard1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID1878 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID1889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration1974 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportDeclaration1984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleXImportDeclaration2021 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_25_in_ruleXImportDeclaration2041 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_26_in_ruleXImportDeclaration2072 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_ruleQualifiedNameInStaticImport_in_ruleXImportDeclaration2109 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_23_in_ruleXImportDeclaration2128 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXImportDeclaration2168 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration2199 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleXImportDeclaration2226 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleXImportDeclaration2240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameInStaticImport_in_entryRuleQualifiedNameInStaticImport2279 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameInStaticImport2290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedNameInStaticImport2337 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedNameInStaticImport2355 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_synpred1_InternalXtype148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_synpred2_InternalXtype600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_synpred3_InternalXtype695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_synpred4_InternalXtype752 = new BitSet(new long[]{0x0000000000000002L});

}
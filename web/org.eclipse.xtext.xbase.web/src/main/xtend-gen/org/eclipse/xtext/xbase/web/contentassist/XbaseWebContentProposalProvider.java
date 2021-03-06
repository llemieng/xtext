/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.web.contentassist;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.eclipse.xtext.web.server.contentassist.CrossrefProposalCreator;
import org.eclipse.xtext.web.server.contentassist.WebContentProposalProvider;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.conversion.XbaseQualifiedNameValueConverter;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.scoping.SyntaxFilteredScopes;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.web.contentassist.ITypeFilter;
import org.eclipse.xtext.xbase.web.contentassist.ITypesProposalProvider;
import org.eclipse.xtext.xbase.web.contentassist.TypeMatchFilters;
import org.eclipse.xtext.xbase.web.contentassist.XbaseCrossrefProposalCreator;
import org.eclipse.xtext.xtype.XtypePackage;

@SuppressWarnings("all")
public class XbaseWebContentProposalProvider extends WebContentProposalProvider {
  public static class ValidFeatureDescription implements Predicate<IEObjectDescription> {
    @Inject
    private OperatorMapping operatorMapping;
    
    @Override
    public boolean apply(final IEObjectDescription input) {
      if ((input instanceof IIdentifiableElementDescription)) {
        final IIdentifiableElementDescription desc = ((IIdentifiableElementDescription) input);
        boolean _or = false;
        boolean _isVisible = desc.isVisible();
        boolean _not = (!_isVisible);
        if (_not) {
          _or = true;
        } else {
          boolean _isValidStaticState = desc.isValidStaticState();
          boolean _not_1 = (!_isValidStaticState);
          _or = _not_1;
        }
        if (_or) {
          return false;
        }
        QualifiedName _name = ((IIdentifiableElementDescription)input).getName();
        String _firstSegment = _name.getFirstSegment();
        boolean _startsWith = _firstSegment.startsWith("operator_");
        if (_startsWith) {
          QualifiedName _name_1 = ((IIdentifiableElementDescription)input).getName();
          QualifiedName _operator = this.operatorMapping.getOperator(_name_1);
          return (_operator == null);
        }
        return true;
      }
      return true;
    }
  }
  
  @Inject
  @Extension
  private XbaseGrammarAccess _xbaseGrammarAccess;
  
  @Inject
  private ITypesProposalProvider typeProposalProvider;
  
  @Inject
  private XbaseWebContentProposalProvider.ValidFeatureDescription featureDescriptionPredicate;
  
  @Inject
  private XbaseQualifiedNameValueConverter qualifiedNameValueConverter;
  
  @Inject
  private IBatchTypeResolver typeResolver;
  
  @Inject
  private CommonTypeComputationServices typeComputationServices;
  
  @Inject
  private SyntaxFilteredScopes syntaxFilteredScopes;
  
  @Override
  protected void _createProposals(final Keyword keyword, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    boolean _isKeywordWorthyToPropose = this.isKeywordWorthyToPropose(keyword, context);
    if (_isKeywordWorthyToPropose) {
      super._createProposals(keyword, context, acceptor);
    }
  }
  
  protected boolean isKeywordWorthyToPropose(final Keyword keyword, final ContentAssistContext context) {
    boolean _or = false;
    String _value = keyword.getValue();
    boolean _equals = Objects.equal(_value, "as");
    if (_equals) {
      _or = true;
    } else {
      String _value_1 = keyword.getValue();
      boolean _equals_1 = Objects.equal(_value_1, "instanceof");
      _or = _equals_1;
    }
    if (_or) {
      final EObject previousModel = context.getPreviousModel();
      if ((previousModel instanceof XExpression)) {
        String _prefix = context.getPrefix();
        int _length = _prefix.length();
        boolean _tripleEquals = (_length == 0);
        if (_tripleEquals) {
          ICompositeNode _node = NodeModelUtils.getNode(previousModel);
          int _endOffset = _node.getEndOffset();
          int _offset = context.getOffset();
          boolean _greaterThan = (_endOffset > _offset);
          if (_greaterThan) {
            return false;
          }
        }
        IResolvedTypes _resolveTypes = this.typeResolver.resolveTypes(previousModel);
        LightweightTypeReference type = _resolveTypes.getActualType(
          ((XExpression) previousModel));
        boolean _or_1 = false;
        if ((type == null)) {
          _or_1 = true;
        } else {
          boolean _isPrimitiveVoid = type.isPrimitiveVoid();
          _or_1 = _isPrimitiveVoid;
        }
        if (_or_1) {
          return false;
        }
      }
    }
    return true;
  }
  
  @Override
  protected void _createProposals(final RuleCall ruleCall, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    AbstractRule _rule = ruleCall.getRule();
    boolean _matched = false;
    if (!_matched) {
      ParserRule _xExpressionRule = this._xbaseGrammarAccess.getXExpressionRule();
      if (Objects.equal(_rule, _xExpressionRule)) {
        _matched=true;
        boolean _and = false;
        EObject _eContainer = ruleCall.eContainer();
        if (!(_eContainer instanceof Group)) {
          _and = false;
        } else {
          AbstractRule _containingRule = GrammarUtil.containingRule(ruleCall);
          String _name = _containingRule.getName();
          boolean _equals = Objects.equal(_name, "XParenthesizedExpression");
          _and = _equals;
        }
        if (_and) {
          EObject _currentModel = context.getCurrentModel();
          this.createLocalVariableAndImplicitProposals(_currentModel, IExpressionScope.Anchor.WITHIN, context, acceptor);
        }
      }
    }
    if (!_matched) {
      super._createProposals(ruleCall, context, acceptor);
    }
  }
  
  @Override
  protected void _createProposals(final Assignment assignment, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    final EObject model = context.getCurrentModel();
    AbstractRule _containingRule = GrammarUtil.containingRule(assignment);
    String _name = _containingRule.getName();
    String _plus = (_name + " - ");
    String _feature = assignment.getFeature();
    String _plus_1 = (_plus + _feature);
    InputOutput.<String>println(_plus_1);
    boolean _matched = false;
    if (!_matched) {
      XbaseGrammarAccess.XFeatureCallElements _xFeatureCallAccess = this._xbaseGrammarAccess.getXFeatureCallAccess();
      Assignment _featureAssignment_2 = _xFeatureCallAccess.getFeatureAssignment_2();
      if (Objects.equal(assignment, _featureAssignment_2)) {
        _matched=true;
        this.completeXFeatureCall(model, context, acceptor);
      }
    }
    if (!_matched) {
      XbaseGrammarAccess.XMemberFeatureCallElements _xMemberFeatureCallAccess = this._xbaseGrammarAccess.getXMemberFeatureCallAccess();
      Assignment _featureAssignment_1_0_0_0_2 = _xMemberFeatureCallAccess.getFeatureAssignment_1_0_0_0_2();
      if (Objects.equal(assignment, _featureAssignment_1_0_0_0_2)) {
        _matched=true;
      }
      if (!_matched) {
        XbaseGrammarAccess.XMemberFeatureCallElements _xMemberFeatureCallAccess_1 = this._xbaseGrammarAccess.getXMemberFeatureCallAccess();
        Assignment _featureAssignment_1_1_2 = _xMemberFeatureCallAccess_1.getFeatureAssignment_1_1_2();
        if (Objects.equal(assignment, _featureAssignment_1_1_2)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.completeXMemberFeatureCall(model, assignment, context, acceptor);
      }
    }
    if (!_matched) {
      XbaseGrammarAccess.XBlockExpressionElements _xBlockExpressionAccess = this._xbaseGrammarAccess.getXBlockExpressionAccess();
      Assignment _expressionsAssignment_2_0 = _xBlockExpressionAccess.getExpressionsAssignment_2_0();
      if (Objects.equal(assignment, _expressionsAssignment_2_0)) {
        _matched=true;
      }
      if (!_matched) {
        XbaseGrammarAccess.XExpressionInClosureElements _xExpressionInClosureAccess = this._xbaseGrammarAccess.getXExpressionInClosureAccess();
        Assignment _expressionsAssignment_1_0 = _xExpressionInClosureAccess.getExpressionsAssignment_1_0();
        if (Objects.equal(assignment, _expressionsAssignment_1_0)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.completeWithinBlock(model, context, acceptor);
      }
    }
    if (!_matched) {
      XbaseGrammarAccess.XAssignmentElements _xAssignmentAccess = this._xbaseGrammarAccess.getXAssignmentAccess();
      Assignment _featureAssignment_0_1 = _xAssignmentAccess.getFeatureAssignment_0_1();
      if (Objects.equal(assignment, _featureAssignment_0_1)) {
        _matched=true;
      }
      if (!_matched) {
        XbaseGrammarAccess.XAssignmentElements _xAssignmentAccess_1 = this._xbaseGrammarAccess.getXAssignmentAccess();
        Assignment _featureAssignment_1_1_0_0_1 = _xAssignmentAccess_1.getFeatureAssignment_1_1_0_0_1();
        if (Objects.equal(assignment, _featureAssignment_1_1_0_0_1)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.completeXAssignment(model, assignment, context, acceptor);
      }
    }
    if (!_matched) {
      XtypeGrammarAccess.JvmParameterizedTypeReferenceElements _jvmParameterizedTypeReferenceAccess = this._xbaseGrammarAccess.getJvmParameterizedTypeReferenceAccess();
      Assignment _typeAssignment_0 = _jvmParameterizedTypeReferenceAccess.getTypeAssignment_0();
      if (Objects.equal(assignment, _typeAssignment_0)) {
        _matched=true;
      }
      if (!_matched) {
        XtypeGrammarAccess.JvmParameterizedTypeReferenceElements _jvmParameterizedTypeReferenceAccess_1 = this._xbaseGrammarAccess.getJvmParameterizedTypeReferenceAccess();
        Assignment _typeAssignment_1_4_1 = _jvmParameterizedTypeReferenceAccess_1.getTypeAssignment_1_4_1();
        if (Objects.equal(assignment, _typeAssignment_1_4_1)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, acceptor);
      }
    }
    if (!_matched) {
      XbaseGrammarAccess.XRelationalExpressionElements _xRelationalExpressionAccess = this._xbaseGrammarAccess.getXRelationalExpressionAccess();
      Assignment _typeAssignment_1_0_1 = _xRelationalExpressionAccess.getTypeAssignment_1_0_1();
      if (Objects.equal(assignment, _typeAssignment_1_0_1)) {
        _matched=true;
        this.completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, acceptor);
      }
    }
    if (!_matched) {
      XtypeGrammarAccess.XImportDeclarationElements _xImportDeclarationAccess = this._xbaseGrammarAccess.getXImportDeclarationAccess();
      Assignment _importedTypeAssignment_1_0_2 = _xImportDeclarationAccess.getImportedTypeAssignment_1_0_2();
      if (Objects.equal(assignment, _importedTypeAssignment_1_0_2)) {
        _matched=true;
      }
      if (!_matched) {
        XtypeGrammarAccess.XImportDeclarationElements _xImportDeclarationAccess_1 = this._xbaseGrammarAccess.getXImportDeclarationAccess();
        Assignment _importedTypeAssignment_1_1 = _xImportDeclarationAccess_1.getImportedTypeAssignment_1_1();
        if (Objects.equal(assignment, _importedTypeAssignment_1_1)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.completeJavaTypes(context, XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE, true, acceptor);
      }
    }
    if (!_matched) {
      XbaseGrammarAccess.XTypeLiteralElements _xTypeLiteralAccess = this._xbaseGrammarAccess.getXTypeLiteralAccess();
      Assignment _typeAssignment_3 = _xTypeLiteralAccess.getTypeAssignment_3();
      if (Objects.equal(assignment, _typeAssignment_3)) {
        _matched=true;
        this.completeJavaTypes(context, XbasePackage.Literals.XTYPE_LITERAL__TYPE, true, acceptor);
      }
    }
    if (!_matched) {
      XbaseGrammarAccess.XConstructorCallElements _xConstructorCallAccess = this._xbaseGrammarAccess.getXConstructorCallAccess();
      Assignment _constructorAssignment_2 = _xConstructorCallAccess.getConstructorAssignment_2();
      if (Objects.equal(assignment, _constructorAssignment_2)) {
        _matched=true;
        ITypeFilter _or = TypeMatchFilters.operator_or(TypeMatchFilters.INTERNAL, TypeMatchFilters.ABSTRACT);
        ITypeFilter _or_1 = TypeMatchFilters.operator_or(_or, TypeMatchFilters.INTERFACE);
        ITypeFilter _not = TypeMatchFilters.operator_not(_or_1);
        this.completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, true, 
          this.qualifiedNameValueConverter, _not, acceptor);
      }
    }
    if (!_matched) {
      XbaseGrammarAccess.XForLoopExpressionElements _xForLoopExpressionAccess = this._xbaseGrammarAccess.getXForLoopExpressionAccess();
      Assignment _eachExpressionAssignment_3 = _xForLoopExpressionAccess.getEachExpressionAssignment_3();
      if (Objects.equal(assignment, _eachExpressionAssignment_3)) {
        _matched=true;
      }
      if (!_matched) {
        XbaseGrammarAccess.XSwitchExpressionElements _xSwitchExpressionAccess = this._xbaseGrammarAccess.getXSwitchExpressionAccess();
        Assignment _defaultAssignment_5_2 = _xSwitchExpressionAccess.getDefaultAssignment_5_2();
        if (Objects.equal(assignment, _defaultAssignment_5_2)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XCasePartElements _xCasePartAccess = this._xbaseGrammarAccess.getXCasePartAccess();
        Assignment _caseAssignment_2_1 = _xCasePartAccess.getCaseAssignment_2_1();
        if (Objects.equal(assignment, _caseAssignment_2_1)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XCatchClauseElements _xCatchClauseAccess = this._xbaseGrammarAccess.getXCatchClauseAccess();
        Assignment _expressionAssignment_4 = _xCatchClauseAccess.getExpressionAssignment_4();
        if (Objects.equal(assignment, _expressionAssignment_4)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XBasicForLoopExpressionElements _xBasicForLoopExpressionAccess = this._xbaseGrammarAccess.getXBasicForLoopExpressionAccess();
        Assignment _updateExpressionsAssignment_7_0 = _xBasicForLoopExpressionAccess.getUpdateExpressionsAssignment_7_0();
        if (Objects.equal(assignment, _updateExpressionsAssignment_7_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XBasicForLoopExpressionElements _xBasicForLoopExpressionAccess_1 = this._xbaseGrammarAccess.getXBasicForLoopExpressionAccess();
        Assignment _updateExpressionsAssignment_7_1_1 = _xBasicForLoopExpressionAccess_1.getUpdateExpressionsAssignment_7_1_1();
        if (Objects.equal(assignment, _updateExpressionsAssignment_7_1_1)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XBasicForLoopExpressionElements _xBasicForLoopExpressionAccess_2 = this._xbaseGrammarAccess.getXBasicForLoopExpressionAccess();
        Assignment _expressionAssignment_5 = _xBasicForLoopExpressionAccess_2.getExpressionAssignment_5();
        if (Objects.equal(assignment, _expressionAssignment_5)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XBasicForLoopExpressionElements _xBasicForLoopExpressionAccess_3 = this._xbaseGrammarAccess.getXBasicForLoopExpressionAccess();
        Assignment _eachExpressionAssignment_9 = _xBasicForLoopExpressionAccess_3.getEachExpressionAssignment_9();
        if (Objects.equal(assignment, _eachExpressionAssignment_9)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XClosureElements _xClosureAccess = this._xbaseGrammarAccess.getXClosureAccess();
        Assignment _expressionAssignment_2 = _xClosureAccess.getExpressionAssignment_2();
        if (Objects.equal(assignment, _expressionAssignment_2)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XShortClosureElements _xShortClosureAccess = this._xbaseGrammarAccess.getXShortClosureAccess();
        Assignment _expressionAssignment_1 = _xShortClosureAccess.getExpressionAssignment_1();
        if (Objects.equal(assignment, _expressionAssignment_1)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.WITHIN, context, acceptor);
      }
    }
    if (!_matched) {
      XbaseGrammarAccess.XForLoopExpressionElements _xForLoopExpressionAccess_1 = this._xbaseGrammarAccess.getXForLoopExpressionAccess();
      Assignment _forExpressionAssignment_1 = _xForLoopExpressionAccess_1.getForExpressionAssignment_1();
      if (Objects.equal(assignment, _forExpressionAssignment_1)) {
        _matched=true;
      }
      if (!_matched) {
        XbaseGrammarAccess.XVariableDeclarationElements _xVariableDeclarationAccess = this._xbaseGrammarAccess.getXVariableDeclarationAccess();
        Assignment _rightAssignment_3_1 = _xVariableDeclarationAccess.getRightAssignment_3_1();
        if (Objects.equal(assignment, _rightAssignment_3_1)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor);
      }
    }
    if (!_matched) {
      XbaseGrammarAccess.XCasePartElements _xCasePartAccess_1 = this._xbaseGrammarAccess.getXCasePartAccess();
      Assignment _thenAssignment_3_0_1 = _xCasePartAccess_1.getThenAssignment_3_0_1();
      if (Objects.equal(assignment, _thenAssignment_3_0_1)) {
        _matched=true;
        this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.AFTER, context, acceptor);
      }
    }
    if (!_matched) {
      XbaseGrammarAccess.XOrExpressionElements _xOrExpressionAccess = this._xbaseGrammarAccess.getXOrExpressionAccess();
      Assignment _featureAssignment_1_0_0_1 = _xOrExpressionAccess.getFeatureAssignment_1_0_0_1();
      if (Objects.equal(assignment, _featureAssignment_1_0_0_1)) {
        _matched=true;
      }
      if (!_matched) {
        XbaseGrammarAccess.XAndExpressionElements _xAndExpressionAccess = this._xbaseGrammarAccess.getXAndExpressionAccess();
        Assignment _featureAssignment_1_0_0_1_1 = _xAndExpressionAccess.getFeatureAssignment_1_0_0_1();
        if (Objects.equal(assignment, _featureAssignment_1_0_0_1_1)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XEqualityExpressionElements _xEqualityExpressionAccess = this._xbaseGrammarAccess.getXEqualityExpressionAccess();
        Assignment _featureAssignment_1_0_0_1_2 = _xEqualityExpressionAccess.getFeatureAssignment_1_0_0_1();
        if (Objects.equal(assignment, _featureAssignment_1_0_0_1_2)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XRelationalExpressionElements _xRelationalExpressionAccess_1 = this._xbaseGrammarAccess.getXRelationalExpressionAccess();
        Assignment _featureAssignment_1_1_0_0_1_1 = _xRelationalExpressionAccess_1.getFeatureAssignment_1_1_0_0_1();
        if (Objects.equal(assignment, _featureAssignment_1_1_0_0_1_1)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XOtherOperatorExpressionElements _xOtherOperatorExpressionAccess = this._xbaseGrammarAccess.getXOtherOperatorExpressionAccess();
        Assignment _featureAssignment_1_0_0_1_3 = _xOtherOperatorExpressionAccess.getFeatureAssignment_1_0_0_1();
        if (Objects.equal(assignment, _featureAssignment_1_0_0_1_3)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XAdditiveExpressionElements _xAdditiveExpressionAccess = this._xbaseGrammarAccess.getXAdditiveExpressionAccess();
        Assignment _featureAssignment_1_0_0_1_4 = _xAdditiveExpressionAccess.getFeatureAssignment_1_0_0_1();
        if (Objects.equal(assignment, _featureAssignment_1_0_0_1_4)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XMultiplicativeExpressionElements _xMultiplicativeExpressionAccess = this._xbaseGrammarAccess.getXMultiplicativeExpressionAccess();
        Assignment _featureAssignment_1_0_0_1_5 = _xMultiplicativeExpressionAccess.getFeatureAssignment_1_0_0_1();
        if (Objects.equal(assignment, _featureAssignment_1_0_0_1_5)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XPostfixOperationElements _xPostfixOperationAccess = this._xbaseGrammarAccess.getXPostfixOperationAccess();
        Assignment _featureAssignment_1_0_1 = _xPostfixOperationAccess.getFeatureAssignment_1_0_1();
        if (Objects.equal(assignment, _featureAssignment_1_0_1)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.completeBinaryOperation(model, assignment, context, acceptor);
      }
    }
    if (!_matched) {
      XbaseGrammarAccess.XBasicForLoopExpressionElements _xBasicForLoopExpressionAccess_4 = this._xbaseGrammarAccess.getXBasicForLoopExpressionAccess();
      Assignment _initExpressionsAssignment_3_0 = _xBasicForLoopExpressionAccess_4.getInitExpressionsAssignment_3_0();
      if (Objects.equal(assignment, _initExpressionsAssignment_3_0)) {
        _matched=true;
      }
      if (!_matched) {
        XbaseGrammarAccess.XBasicForLoopExpressionElements _xBasicForLoopExpressionAccess_5 = this._xbaseGrammarAccess.getXBasicForLoopExpressionAccess();
        Assignment _initExpressionsAssignment_3_1_1 = _xBasicForLoopExpressionAccess_5.getInitExpressionsAssignment_3_1_1();
        if (Objects.equal(assignment, _initExpressionsAssignment_3_1_1)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.completeXBasicForLoopInit(model, context, acceptor);
      }
    }
    if (!_matched) {
      XbaseGrammarAccess.XUnaryOperationElements _xUnaryOperationAccess = this._xbaseGrammarAccess.getXUnaryOperationAccess();
      Assignment _featureAssignment_0_1_1 = _xUnaryOperationAccess.getFeatureAssignment_0_1();
      if (Objects.equal(assignment, _featureAssignment_0_1_1)) {
        _matched=true;
      }
    }
    if (!_matched) {
      super._createProposals(assignment, context, acceptor);
    }
  }
  
  protected void completeJavaTypes(final ContentAssistContext context, final EReference reference, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    ITypeFilter _not = TypeMatchFilters.operator_not(TypeMatchFilters.INTERNAL);
    this.completeJavaTypes(context, reference, false, this.qualifiedNameValueConverter, _not, acceptor);
  }
  
  protected void completeJavaTypes(final ContentAssistContext context, final EReference reference, final boolean forced, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    ITypeFilter _not = TypeMatchFilters.operator_not(TypeMatchFilters.INTERNAL);
    this.completeJavaTypes(context, reference, forced, this.qualifiedNameValueConverter, _not, acceptor);
  }
  
  protected void completeJavaTypes(final ContentAssistContext context, final EReference reference, final boolean forced, final IValueConverter<String> valueConverter, final ITypeFilter filter, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    final String prefix = context.getPrefix();
    int _length = prefix.length();
    boolean _greaterThan = (_length > 0);
    if (_greaterThan) {
      char _charAt = prefix.charAt(0);
      boolean _isJavaIdentifierStart = Character.isJavaIdentifierStart(_charAt);
      if (_isJavaIdentifierStart) {
        boolean _and = false;
        boolean _and_1 = false;
        boolean _and_2 = false;
        if (!(!forced)) {
          _and_2 = false;
        } else {
          boolean _contains = prefix.contains(".");
          boolean _not = (!_contains);
          _and_2 = _not;
        }
        if (!_and_2) {
          _and_1 = false;
        } else {
          boolean _contains_1 = prefix.contains("::");
          boolean _not_1 = (!_contains_1);
          _and_1 = _not_1;
        }
        if (!_and_1) {
          _and = false;
        } else {
          char _charAt_1 = prefix.charAt(0);
          boolean _isUpperCase = Character.isUpperCase(_charAt_1);
          boolean _not_2 = (!_isUpperCase);
          _and = _not_2;
        }
        if (_and) {
          return;
        }
        this.typeProposalProvider.createTypeProposals(context, reference, valueConverter, filter, acceptor);
      }
    } else {
      if (forced) {
        final INode lastCompleteNode = context.getLastCompleteNode();
        boolean _and_3 = false;
        boolean _and_4 = false;
        boolean _and_5 = false;
        if (!(lastCompleteNode instanceof ILeafNode)) {
          _and_5 = false;
        } else {
          boolean _isHidden = ((ILeafNode) lastCompleteNode).isHidden();
          boolean _not_3 = (!_isHidden);
          _and_5 = _not_3;
        }
        if (!_and_5) {
          _and_4 = false;
        } else {
          int _length_1 = lastCompleteNode.getLength();
          boolean _greaterThan_1 = (_length_1 > 0);
          _and_4 = _greaterThan_1;
        }
        if (!_and_4) {
          _and_3 = false;
        } else {
          int _totalEndOffset = lastCompleteNode.getTotalEndOffset();
          int _offset = context.getOffset();
          boolean _equals = (_totalEndOffset == _offset);
          _and_3 = _equals;
        }
        if (_and_3) {
          final String text = lastCompleteNode.getText();
          int _length_2 = text.length();
          int _minus = (_length_2 - 1);
          char _charAt_2 = text.charAt(_minus);
          boolean _isJavaIdentifierPart = Character.isJavaIdentifierPart(_charAt_2);
          if (_isJavaIdentifierPart) {
            return;
          }
        }
        this.typeProposalProvider.createTypeProposals(context, reference, valueConverter, filter, acceptor);
      }
    }
  }
  
  protected void completeXFeatureCall(final EObject model, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    if ((model != null)) {
      IResolvedTypes _resolveTypes = this.typeResolver.resolveTypes(model);
      boolean _hasExpressionScope = _resolveTypes.hasExpressionScope(model, IExpressionScope.Anchor.WITHIN);
      if (_hasExpressionScope) {
        return;
      }
    }
    if ((model instanceof XMemberFeatureCall)) {
      final ICompositeNode node = NodeModelUtils.getNode(model);
      int _endOffset = node.getEndOffset();
      boolean _isInMemberFeatureCall = this.isInMemberFeatureCall(model, _endOffset, context);
      if (_isInMemberFeatureCall) {
        return;
      }
    }
    this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.AFTER, context, acceptor);
  }
  
  protected void completeWithinBlock(final EObject model, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    final ICompositeNode node = NodeModelUtils.getNode(model);
    int _offset = node.getOffset();
    int _offset_1 = context.getOffset();
    boolean _greaterEqualsThan = (_offset >= _offset_1);
    if (_greaterEqualsThan) {
      this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor);
      return;
    }
    if ((model instanceof XBlockExpression)) {
      final EList<XExpression> children = ((XBlockExpression) model).getExpressions();
      for (int i = (children.size() - 1); (i >= 0); i--) {
        {
          final XExpression child = children.get(i);
          final ICompositeNode childNode = NodeModelUtils.getNode(child);
          int _endOffset = childNode.getEndOffset();
          int _offset_2 = context.getOffset();
          boolean _lessEqualsThan = (_endOffset <= _offset_2);
          if (_lessEqualsThan) {
            this.createLocalVariableAndImplicitProposals(child, IExpressionScope.Anchor.AFTER, context, acceptor);
            return;
          }
        }
      }
    }
    int endOffset = node.getEndOffset();
    int _offset_2 = context.getOffset();
    boolean _lessEqualsThan = (endOffset <= _offset_2);
    if (_lessEqualsThan) {
      boolean _or = false;
      if (((model instanceof XFeatureCall) && (model.eContainer() instanceof XClosure))) {
        _or = true;
      } else {
        boolean _and = false;
        int _offset_3 = context.getOffset();
        boolean _equals = (endOffset == _offset_3);
        if (!_equals) {
          _and = false;
        } else {
          String _prefix = context.getPrefix();
          int _length = _prefix.length();
          boolean _equals_1 = (_length == 0);
          _and = _equals_1;
        }
        _or = _and;
      }
      if (_or) {
        return;
      }
      boolean _isInMemberFeatureCall = this.isInMemberFeatureCall(model, endOffset, context);
      if (_isInMemberFeatureCall) {
        return;
      }
      this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.AFTER, context, acceptor);
      return;
    }
    boolean _or_1 = false;
    boolean _isInMemberFeatureCall_1 = this.isInMemberFeatureCall(model, endOffset, context);
    if (_isInMemberFeatureCall_1) {
      _or_1 = true;
    } else {
      _or_1 = (model instanceof XClosure);
    }
    if (_or_1) {
      return;
    }
    this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor);
  }
  
  protected boolean isInMemberFeatureCall(final EObject model, final int endOffset, final ContentAssistContext context) {
    boolean _and = false;
    if (!(model instanceof XMemberFeatureCall)) {
      _and = false;
    } else {
      int _offset = context.getOffset();
      boolean _greaterEqualsThan = (endOffset >= _offset);
      _and = _greaterEqualsThan;
    }
    if (_and) {
      final List<INode> featureNodes = NodeModelUtils.findNodesForFeature(model, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
      boolean _isEmpty = featureNodes.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final INode featureNode = IterableExtensions.<INode>head(featureNodes);
        boolean _and_1 = false;
        int _totalOffset = featureNode.getTotalOffset();
        int _offset_1 = context.getOffset();
        boolean _lessThan = (_totalOffset < _offset_1);
        if (!_lessThan) {
          _and_1 = false;
        } else {
          int _totalEndOffset = featureNode.getTotalEndOffset();
          int _offset_2 = context.getOffset();
          boolean _greaterEqualsThan_1 = (_totalEndOffset >= _offset_2);
          _and_1 = _greaterEqualsThan_1;
        }
        if (_and_1) {
          return true;
        }
      }
    }
    return false;
  }
  
  protected void completeXAssignment(final EObject model, final Assignment assignment, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    final String ruleName = this.getConcreteSyntaxRuleName(assignment);
    boolean _isOperatorRule = this.isOperatorRule(ruleName);
    if (_isOperatorRule) {
      this.completeBinaryOperation(model, assignment, context, acceptor);
    }
  }
  
  protected boolean isOperatorRule(final String ruleName) {
    boolean _and = false;
    if (!(ruleName != null)) {
      _and = false;
    } else {
      boolean _startsWith = ruleName.startsWith("Op");
      _and = _startsWith;
    }
    return _and;
  }
  
  protected void completeBinaryOperation(final EObject model, final Assignment assignment, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    if ((model instanceof XBinaryOperation)) {
      String _prefix = context.getPrefix();
      int _length = _prefix.length();
      boolean _tripleEquals = (_length == 0);
      if (_tripleEquals) {
        final INode currentNode = context.getCurrentNode();
        final int offset = currentNode.getOffset();
        final int endOffset = currentNode.getEndOffset();
        boolean _and = false;
        int _offset = context.getOffset();
        boolean _lessThan = (offset < _offset);
        if (!_lessThan) {
          _and = false;
        } else {
          int _offset_1 = context.getOffset();
          boolean _greaterEqualsThan = (endOffset >= _offset_1);
          _and = _greaterEqualsThan;
        }
        if (_and) {
          EObject _grammarElement = currentNode.getGrammarElement();
          if ((_grammarElement instanceof CrossReference)) {
            return;
          }
        }
      }
      ICompositeNode _findActualNodeFor = NodeModelUtils.findActualNodeFor(model);
      int _endOffset = _findActualNodeFor.getEndOffset();
      int _offset_2 = context.getOffset();
      boolean _lessEqualsThan = (_endOffset <= _offset_2);
      if (_lessEqualsThan) {
        AbstractElement _terminal = assignment.getTerminal();
        this.createReceiverProposals(((XExpression) model), ((CrossReference) _terminal), context, acceptor);
      } else {
        XExpression _leftOperand = ((XBinaryOperation) model).getLeftOperand();
        AbstractElement _terminal_1 = assignment.getTerminal();
        this.createReceiverProposals(_leftOperand, 
          ((CrossReference) _terminal_1), context, acceptor);
      }
    } else {
      final EObject previousModel = context.getPreviousModel();
      if ((previousModel instanceof XExpression)) {
        String _prefix_1 = context.getPrefix();
        int _length_1 = _prefix_1.length();
        boolean _tripleEquals_1 = (_length_1 == 0);
        if (_tripleEquals_1) {
          ICompositeNode _node = NodeModelUtils.getNode(previousModel);
          int _endOffset_1 = _node.getEndOffset();
          int _offset_3 = context.getOffset();
          boolean _greaterThan = (_endOffset_1 > _offset_3);
          if (_greaterThan) {
            return;
          }
        }
        AbstractElement _terminal_2 = assignment.getTerminal();
        this.createReceiverProposals(((XExpression) previousModel), 
          ((CrossReference) _terminal_2), context, acceptor);
      }
    }
  }
  
  protected void completeXBasicForLoopInit(final EObject model, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    final ICompositeNode node = NodeModelUtils.getNode(model);
    int _offset = node.getOffset();
    int _offset_1 = context.getOffset();
    boolean _greaterEqualsThan = (_offset >= _offset_1);
    if (_greaterEqualsThan) {
      this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor);
      return;
    }
    if ((model instanceof XBasicForLoopExpression)) {
      final EList<XExpression> children = ((XBasicForLoopExpression) model).getInitExpressions();
      for (int i = (children.size() - 1); (i >= 0); i--) {
        {
          final XExpression child = children.get(i);
          final ICompositeNode childNode = NodeModelUtils.getNode(child);
          int _endOffset = childNode.getEndOffset();
          int _offset_2 = context.getOffset();
          boolean _lessEqualsThan = (_endOffset <= _offset_2);
          if (_lessEqualsThan) {
            this.createLocalVariableAndImplicitProposals(child, IExpressionScope.Anchor.AFTER, context, acceptor);
            return;
          }
        }
      }
    }
    this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor);
  }
  
  protected void completeXMemberFeatureCall(final EObject model, final Assignment assignment, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    if ((model instanceof XMemberFeatureCall)) {
      XExpression _memberCallTarget = ((XMemberFeatureCall) model).getMemberCallTarget();
      AbstractElement _terminal = assignment.getTerminal();
      this.createReceiverProposals(_memberCallTarget, 
        ((CrossReference) _terminal), context, acceptor);
    } else {
      if ((model instanceof XAssignment)) {
        XExpression _assignable = ((XAssignment) model).getAssignable();
        AbstractElement _terminal_1 = assignment.getTerminal();
        this.createReceiverProposals(_assignable, 
          ((CrossReference) _terminal_1), context, acceptor);
      }
    }
  }
  
  protected void createLocalVariableAndImplicitProposals(final EObject model, final IExpressionScope.Anchor anchor, final ContentAssistContext contentAssistContext, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    String prefix = contentAssistContext.getPrefix();
    int _length = prefix.length();
    boolean _greaterThan = (_length > 0);
    if (_greaterThan) {
      char _charAt = prefix.charAt(0);
      boolean _isJavaIdentifierStart = Character.isJavaIdentifierStart(_charAt);
      boolean _not = (!_isJavaIdentifierStart);
      if (_not) {
        return;
      }
    }
    IResolvedTypes _xifexpression = null;
    if ((model != null)) {
      _xifexpression = this.typeResolver.resolveTypes(model);
    } else {
      XtextResource _resource = contentAssistContext.getResource();
      _xifexpression = this.typeResolver.resolveTypes(_resource);
    }
    final IResolvedTypes resolvedTypes = _xifexpression;
    final IExpressionScope expressionScope = resolvedTypes.getExpressionScope(model, anchor);
    final IScope scope = expressionScope.getFeatureScope();
    IQualifiedNameConverter _qualifiedNameConverter = this.getQualifiedNameConverter();
    final XbaseCrossrefProposalCreator proposalCreator = new XbaseCrossrefProposalCreator(contentAssistContext, _qualifiedNameConverter, 
      this.typeComputationServices, "IdOrSuper");
    this.lookupCrossReference(scope, model, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, acceptor, this.featureDescriptionPredicate, proposalCreator);
  }
  
  protected void createReceiverProposals(final XExpression receiver, final CrossReference crossReference, final ContentAssistContext contentAssistContext, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(receiver);
    final LightweightTypeReference receiverType = resolvedTypes.getActualType(receiver);
    boolean _or = false;
    if ((receiverType == null)) {
      _or = true;
    } else {
      boolean _isPrimitiveVoid = receiverType.isPrimitiveVoid();
      _or = _isPrimitiveVoid;
    }
    if (_or) {
      return;
    }
    final IExpressionScope expressionScope = resolvedTypes.getExpressionScope(receiver, IExpressionScope.Anchor.RECEIVER);
    IScope scope = null;
    final EObject currentModel = contentAssistContext.getCurrentModel();
    if ((currentModel != receiver)) {
      boolean _and = false;
      if (!(currentModel instanceof XMemberFeatureCall)) {
        _and = false;
      } else {
        XExpression _memberCallTarget = ((XMemberFeatureCall) currentModel).getMemberCallTarget();
        boolean _tripleEquals = (_memberCallTarget == receiver);
        _and = _tripleEquals;
      }
      if (_and) {
        IScope _featureScope = expressionScope.getFeatureScope(((XAbstractFeatureCall) currentModel));
        IScope _create = this.syntaxFilteredScopes.create(_featureScope, crossReference);
        scope = _create;
      } else {
        IScope _featureScope_1 = expressionScope.getFeatureScope();
        IScope _create_1 = this.syntaxFilteredScopes.create(_featureScope_1, crossReference);
        scope = _create_1;
      }
    } else {
      IScope _featureScope_2 = expressionScope.getFeatureScope();
      IScope _create_2 = this.syntaxFilteredScopes.create(_featureScope_2, crossReference);
      scope = _create_2;
    }
    final String ruleName = this.getConcreteSyntaxRuleName(crossReference);
    IQualifiedNameConverter _qualifiedNameConverter = this.getQualifiedNameConverter();
    final XbaseCrossrefProposalCreator proposalCreator = new XbaseCrossrefProposalCreator(contentAssistContext, _qualifiedNameConverter, 
      this.typeComputationServices, ruleName);
    this.lookupCrossReference(scope, receiver, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, acceptor, this.featureDescriptionPredicate, proposalCreator);
  }
  
  protected String _getConcreteSyntaxRuleName(final Assignment assignment) {
    AbstractElement _terminal = assignment.getTerminal();
    return this.getConcreteSyntaxRuleName(_terminal);
  }
  
  protected String _getConcreteSyntaxRuleName(final CrossReference crossReference) {
    String _xifexpression = null;
    AbstractElement _terminal = crossReference.getTerminal();
    if ((_terminal instanceof RuleCall)) {
      AbstractElement _terminal_1 = crossReference.getTerminal();
      _xifexpression = this.getConcreteSyntaxRuleName(_terminal_1);
    }
    return _xifexpression;
  }
  
  protected String _getConcreteSyntaxRuleName(final RuleCall ruleCall) {
    AbstractRule _rule = ruleCall.getRule();
    return _rule.getName();
  }
  
  protected void lookupCrossReference(final IScope scope, final EObject model, final EReference reference, final IAcceptor<ContentAssistResult.Entry> acceptor, final Predicate<IEObjectDescription> filter, final CrossrefProposalCreator proposalCreator) {
    Iterable<IEObjectDescription> _allElements = scope.getAllElements();
    for (final IEObjectDescription candidate : _allElements) {
      boolean _apply = filter.apply(candidate);
      if (_apply) {
        ContentAssistResult.Entry _apply_1 = proposalCreator.apply(candidate);
        acceptor.accept(_apply_1);
      }
    }
  }
  
  public void createProposals(final AbstractElement assignment, final ContentAssistContext context, final IAcceptor<ContentAssistResult.Entry> acceptor) {
    if (assignment instanceof Assignment) {
      _createProposals((Assignment)assignment, context, acceptor);
      return;
    } else if (assignment instanceof CrossReference) {
      _createProposals((CrossReference)assignment, context, acceptor);
      return;
    } else if (assignment instanceof Keyword) {
      _createProposals((Keyword)assignment, context, acceptor);
      return;
    } else if (assignment instanceof RuleCall) {
      _createProposals((RuleCall)assignment, context, acceptor);
      return;
    } else if (assignment != null) {
      _createProposals(assignment, context, acceptor);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(assignment, context, acceptor).toString());
    }
  }
  
  protected String getConcreteSyntaxRuleName(final AbstractElement assignment) {
    if (assignment instanceof Assignment) {
      return _getConcreteSyntaxRuleName((Assignment)assignment);
    } else if (assignment instanceof CrossReference) {
      return _getConcreteSyntaxRuleName((CrossReference)assignment);
    } else if (assignment instanceof RuleCall) {
      return _getConcreteSyntaxRuleName((RuleCall)assignment);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(assignment).toString());
    }
  }
}

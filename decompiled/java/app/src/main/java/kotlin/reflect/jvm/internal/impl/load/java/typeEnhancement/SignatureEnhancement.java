package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionNInfo;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DescriptorBasedDeprecationInfoKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SignatureEnhancement {
    private final JavaTypeEnhancement typeEnhancement;

    public SignatureEnhancement(JavaTypeEnhancement typeEnhancement) {
        Intrinsics.checkNotNullParameter(typeEnhancement, "typeEnhancement");
        this.typeEnhancement = typeEnhancement;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(LazyJavaResolverContext c, Collection<? extends D> platformSignatures) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(platformSignatures, "platformSignatures");
        Collection<? extends D> collection = platformSignatures;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(enhanceSignature((CallableMemberDescriptor) it.next(), c));
        }
        return arrayList;
    }

    private final <D extends CallableMemberDescriptor> Annotations getDefaultAnnotations(D d, LazyJavaResolverContext lazyJavaResolverContext) {
        ClassifierDescriptor topLevelContainingClassifier = DescriptorUtilKt.getTopLevelContainingClassifier(d);
        if (topLevelContainingClassifier == null) {
            return d.getAnnotations();
        }
        LazyJavaClassDescriptor lazyJavaClassDescriptor = topLevelContainingClassifier instanceof LazyJavaClassDescriptor ? (LazyJavaClassDescriptor) topLevelContainingClassifier : null;
        List<JavaAnnotation> moduleAnnotations = lazyJavaClassDescriptor != null ? lazyJavaClassDescriptor.getModuleAnnotations() : null;
        List<JavaAnnotation> list = moduleAnnotations;
        if (list == null || list.isEmpty()) {
            return d.getAnnotations();
        }
        List<JavaAnnotation> list2 = moduleAnnotations;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new LazyJavaAnnotationDescriptor(lazyJavaResolverContext, (JavaAnnotation) it.next(), true));
        }
        return Annotations.Companion.create(CollectionsKt.plus((Iterable) d.getAnnotations(), (Iterable) arrayList));
    }

    /* JADX WARN: Code duplicated, block: B:111:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d7  */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x023c, code lost:
    
        if (r1 == null) goto L131;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <D extends CallableMemberDescriptor> D enhanceSignature(D d, LazyJavaResolverContext lazyJavaResolverContext) {
        CallableDescriptor callableDescriptor;
        KotlinType kotlinTypeEnhanceValueParameter;
        PredefinedFunctionEnhancementInfo predefinedFunctionEnhancementInfo;
        Pair<CallableDescriptor.UserDataKey<?>, ?> pair;
        KotlinType type;
        boolean z;
        boolean z2;
        KotlinType type2;
        List<TypeEnhancementInfo> parametersInfo;
        String errorsSinceLanguageVersion;
        PropertyDescriptorImpl propertyDescriptorImpl;
        PropertyGetterDescriptorImpl getter;
        if ((d instanceof JavaCallableMemberDescriptor) && (d.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE || d.getOriginal().getOverriddenDescriptors().size() != 1)) {
            LazyJavaResolverContext lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, getDefaultAnnotations(d, lazyJavaResolverContext));
            if (!(d instanceof JavaPropertyDescriptor) || (getter = (propertyDescriptorImpl = (PropertyDescriptorImpl) d).getGetter()) == null || getter.isDefault()) {
                callableDescriptor = d;
            } else {
                PropertyGetterDescriptorImpl getter2 = propertyDescriptorImpl.getGetter();
                Intrinsics.checkNotNull(getter2);
                callableDescriptor = getter2;
            }
            D d2 = d;
            if (d2.getExtensionReceiverParameter() != null) {
                FunctionDescriptor functionDescriptor = callableDescriptor instanceof FunctionDescriptor ? (FunctionDescriptor) callableDescriptor : null;
                kotlinTypeEnhanceValueParameter = enhanceValueParameter(d, functionDescriptor != null ? (ValueParameterDescriptor) functionDescriptor.getUserData(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER) : null, lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers, null, false, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$0
                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: invoke */
                    public Object invoke2(Object obj) {
                        return SignatureEnhancement.enhanceSignature$lambda$2((CallableMemberDescriptor) obj);
                    }
                });
            } else {
                kotlinTypeEnhanceValueParameter = null;
            }
            JavaMethodDescriptor javaMethodDescriptor = d instanceof JavaMethodDescriptor ? (JavaMethodDescriptor) d : null;
            int i = 0;
            if (javaMethodDescriptor != null) {
                SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
                DeclarationDescriptor containingDeclaration = javaMethodDescriptor.getContainingDeclaration();
                Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                String strSignature = MethodSignatureBuildingUtilsKt.signature(signatureBuildingComponents, (ClassDescriptor) containingDeclaration, MethodSignatureMappingKt.computeJvmDescriptor$default(javaMethodDescriptor, false, false, 3, null));
                if (strSignature != null) {
                    PredefinedFunctionEnhancementInfo warningModeClone = PredefinedEnhancementInfoKt.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE().get(strSignature);
                    if (warningModeClone == null) {
                        warningModeClone = null;
                    } else {
                        if (warningModeClone.getErrorsSinceLanguageVersion() != null && ((errorsSinceLanguageVersion = warningModeClone.getErrorsSinceLanguageVersion()) == null || !StringsKt.startsWith$default(errorsSinceLanguageVersion, "2.", false, 2, (Object) null))) {
                            throw new IllegalStateException("Check failed.");
                        }
                        if (warningModeClone.getErrorsSinceLanguageVersion() != null) {
                            warningModeClone = warningModeClone.getWarningModeClone();
                        }
                    }
                    predefinedFunctionEnhancementInfo = warningModeClone;
                } else {
                    predefinedFunctionEnhancementInfo = null;
                }
            } else {
                predefinedFunctionEnhancementInfo = null;
            }
            if (predefinedFunctionEnhancementInfo != null) {
                predefinedFunctionEnhancementInfo.getParametersInfo().size();
                ((JavaMethodDescriptor) d).getValueParameters().size();
            }
            boolean z3 = (UtilsKt.isJspecifyEnabledInStrictMode(lazyJavaResolverContext.getComponents().getJavaTypeEnhancementState()) || lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers.getComponents().getSettings().getIgnoreNullabilityForErasedValueParameters()) && UtilsKt.hasErasedValueParameters(d);
            List<ValueParameterDescriptor> valueParameters = callableDescriptor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            List<ValueParameterDescriptor> list = valueParameters;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (final ValueParameterDescriptor valueParameterDescriptor : list) {
                ArrayList arrayList2 = arrayList;
                arrayList2.add(enhanceValueParameter(d, valueParameterDescriptor, lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers, (predefinedFunctionEnhancementInfo == null || (parametersInfo = predefinedFunctionEnhancementInfo.getParametersInfo()) == null) ? null : (TypeEnhancementInfo) CollectionsKt.getOrNull(parametersInfo, valueParameterDescriptor.getIndex()), z3, new Function1(valueParameterDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$1
                    private final ValueParameterDescriptor arg$0;

                    {
                        this.arg$0 = valueParameterDescriptor;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: invoke */
                    public Object invoke2(Object obj) {
                        return SignatureEnhancement.enhanceSignature$lambda$9$lambda$8(this.arg$0, (CallableMemberDescriptor) obj);
                    }
                }));
                arrayList = arrayList2;
            }
            ArrayList arrayList3 = arrayList;
            CallableDescriptor callableDescriptor2 = callableDescriptor;
            PropertyDescriptor propertyDescriptor = d instanceof PropertyDescriptor ? (PropertyDescriptor) d : null;
            KotlinType kotlinTypeEnhance$default = enhance$default(this, d, callableDescriptor2, true, lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers, (propertyDescriptor == null || !JavaDescriptorUtilKt.isJavaField(propertyDescriptor)) ? AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE : AnnotationQualifierApplicabilityType.FIELD, predefinedFunctionEnhancementInfo != null ? predefinedFunctionEnhancementInfo.getReturnTypeInfo() : null, false, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$2
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public Object invoke2(Object obj) {
                    return SignatureEnhancement.enhanceSignature$lambda$10((CallableMemberDescriptor) obj);
                }
            }, 32, null);
            KotlinType returnType = d2.getReturnType();
            Intrinsics.checkNotNull(returnType);
            if (containsFunctionN(returnType)) {
                pair = TuplesKt.to(DescriptorBasedDeprecationInfoKt.getDEPRECATED_FUNCTION_KEY(), new DeprecationCausedByFunctionNInfo(d));
            } else {
                ReceiverParameterDescriptor extensionReceiverParameter = d2.getExtensionReceiverParameter();
                if ((extensionReceiverParameter == null || (type2 = extensionReceiverParameter.getType()) == null) ? false : containsFunctionN(type2)) {
                    pair = TuplesKt.to(DescriptorBasedDeprecationInfoKt.getDEPRECATED_FUNCTION_KEY(), new DeprecationCausedByFunctionNInfo(d));
                } else {
                    List<ValueParameterDescriptor> valueParameters2 = d2.getValueParameters();
                    Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
                    List<ValueParameterDescriptor> list2 = valueParameters2;
                    if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                        Iterator<T> it = list2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            KotlinType type3 = ((ValueParameterDescriptor) it.next()).getType();
                            Intrinsics.checkNotNullExpressionValue(type3, "getType(...)");
                            if (containsFunctionN(type3)) {
                                z2 = true;
                                break;
                            }
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                    if (z2) {
                        pair = TuplesKt.to(DescriptorBasedDeprecationInfoKt.getDEPRECATED_FUNCTION_KEY(), new DeprecationCausedByFunctionNInfo(d));
                    } else {
                        pair = null;
                    }
                }
            }
            if (kotlinTypeEnhanceValueParameter == null && kotlinTypeEnhance$default == null) {
                ArrayList arrayList4 = arrayList3;
                if (!(arrayList4 instanceof Collection) || !arrayList4.isEmpty()) {
                    Iterator it2 = arrayList4.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        }
                        if (((KotlinType) it2.next()) != null) {
                            z = true;
                            break;
                        }
                    }
                } else {
                    z = false;
                    break;
                }
                if (!z) {
                }
            }
            JavaCallableMemberDescriptor javaCallableMemberDescriptor = (JavaCallableMemberDescriptor) d;
            if (kotlinTypeEnhanceValueParameter == null) {
                ReceiverParameterDescriptor extensionReceiverParameter2 = d2.getExtensionReceiverParameter();
                type = extensionReceiverParameter2 != null ? extensionReceiverParameter2.getType() : null;
            } else {
                type = kotlinTypeEnhanceValueParameter;
            }
            ArrayList arrayList5 = arrayList3;
            ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
            for (Object obj : arrayList5) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                KotlinType type4 = (KotlinType) obj;
                if (type4 == null) {
                    type4 = d2.getValueParameters().get(i).getType();
                    Intrinsics.checkNotNullExpressionValue(type4, "getType(...)");
                }
                arrayList6.add(type4);
                i = i2;
            }
            ArrayList arrayList7 = arrayList6;
            if (kotlinTypeEnhance$default == null) {
                kotlinTypeEnhance$default = d2.getReturnType();
                Intrinsics.checkNotNull(kotlinTypeEnhance$default);
            }
            JavaCallableMemberDescriptor javaCallableMemberDescriptorEnhance = javaCallableMemberDescriptor.enhance(type, arrayList7, kotlinTypeEnhance$default, pair);
            Intrinsics.checkNotNull(javaCallableMemberDescriptorEnhance, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
            return javaCallableMemberDescriptorEnhance;
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType enhanceSignature$lambda$2(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ReceiverParameterDescriptor extensionReceiverParameter = it.getExtensionReceiverParameter();
        Intrinsics.checkNotNull(extensionReceiverParameter);
        KotlinType type = extensionReceiverParameter.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType enhanceSignature$lambda$9$lambda$8(ValueParameterDescriptor valueParameterDescriptor, CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KotlinType type = it.getValueParameters().get(valueParameterDescriptor.getIndex()).getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType enhanceSignature$lambda$10(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KotlinType returnType = it.getReturnType();
        Intrinsics.checkNotNull(returnType);
        return returnType;
    }

    public final List<KotlinType> enhanceTypeParameterBounds(TypeParameterDescriptor typeParameter, List<? extends KotlinType> bounds, LazyJavaResolverContext context) {
        KotlinType kotlinType;
        KotlinType kotlinTypeEnhance$default;
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(context, "context");
        List<? extends KotlinType> list = bounds;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (KotlinType kotlinType2 : list) {
            if (TypeUtilsKt.contains(kotlinType2, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$3
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public Object invoke2(Object obj) {
                    return Boolean.valueOf(SignatureEnhancement.enhanceTypeParameterBounds$lambda$15$lambda$14((UnwrappedType) obj));
                }
            })) {
                kotlinType = kotlinType2;
            } else {
                kotlinType = kotlinType2;
                kotlinTypeEnhance$default = enhance$default(this, new SignatureParts(typeParameter, false, context, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, false, 16, null), kotlinType, CollectionsKt.emptyList(), null, false, 12, null);
                if (kotlinTypeEnhance$default == null) {
                }
                arrayList.add(kotlinTypeEnhance$default);
            }
            kotlinTypeEnhance$default = kotlinType;
            arrayList.add(kotlinTypeEnhance$default);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enhanceTypeParameterBounds$lambda$15$lambda$14(UnwrappedType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof RawType;
    }

    public final KotlinType enhanceSuperType(KotlinType type, LazyJavaResolverContext context) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(context, "context");
        KotlinType kotlinTypeEnhance$default = enhance$default(this, new SignatureParts(null, false, context, AnnotationQualifierApplicabilityType.TYPE_USE, true), type, CollectionsKt.emptyList(), null, false, 12, null);
        return kotlinTypeEnhance$default == null ? type : kotlinTypeEnhance$default;
    }

    private final boolean containsFunctionN(KotlinType kotlinType) {
        return TypeUtils.contains(kotlinType, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$4
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public Object invoke2(Object obj) {
                return SignatureEnhancement.containsFunctionN$lambda$16((UnwrappedType) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean containsFunctionN$lambda$16(UnwrappedType unwrappedType) {
        ClassifierDescriptor classifierDescriptorMo1820getDeclarationDescriptor = unwrappedType.getConstructor().mo1820getDeclarationDescriptor();
        boolean z = false;
        if (classifierDescriptorMo1820getDeclarationDescriptor == null) {
            return false;
        }
        if (Intrinsics.areEqual(classifierDescriptorMo1820getDeclarationDescriptor.getName(), JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME().shortName()) && Intrinsics.areEqual(DescriptorUtilsKt.fqNameOrNull(classifierDescriptorMo1820getDeclarationDescriptor), JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME())) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    private final KotlinType enhanceValueParameter(CallableMemberDescriptor callableMemberDescriptor, ValueParameterDescriptor valueParameterDescriptor, LazyJavaResolverContext lazyJavaResolverContext, TypeEnhancementInfo typeEnhancementInfo, boolean z, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        LazyJavaResolverContext lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers;
        return enhance(callableMemberDescriptor, valueParameterDescriptor, false, (valueParameterDescriptor == null || (lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, valueParameterDescriptor.getAnnotations())) == null) ? lazyJavaResolverContext : lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, typeEnhancementInfo, z, function1);
    }

    static /* synthetic */ KotlinType enhance$default(SignatureEnhancement signatureEnhancement, CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, TypeEnhancementInfo typeEnhancementInfo, boolean z2, Function1 function1, int i, Object obj) {
        return signatureEnhancement.enhance(callableMemberDescriptor, annotated, z, lazyJavaResolverContext, annotationQualifierApplicabilityType, typeEnhancementInfo, (i & 32) != 0 ? false : z2, function1);
    }

    private final KotlinType enhance(CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, TypeEnhancementInfo typeEnhancementInfo, boolean z2, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        SignatureParts signatureParts = new SignatureParts(annotated, z, lazyJavaResolverContext, annotationQualifierApplicabilityType, false, 16, null);
        KotlinType kotlinTypeInvoke2 = function1.invoke2(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
        Collection<? extends CallableMemberDescriptor> collection = overriddenDescriptors;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            Intrinsics.checkNotNull(callableMemberDescriptor2);
            arrayList.add(function1.invoke2(callableMemberDescriptor2));
        }
        return enhance(signatureParts, kotlinTypeInvoke2, arrayList, typeEnhancementInfo, z2);
    }

    static /* synthetic */ KotlinType enhance$default(SignatureEnhancement signatureEnhancement, SignatureParts signatureParts, KotlinType kotlinType, List list, TypeEnhancementInfo typeEnhancementInfo, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            typeEnhancementInfo = null;
        }
        return signatureEnhancement.enhance(signatureParts, kotlinType, list, typeEnhancementInfo, (i & 8) != 0 ? false : z);
    }

    private final KotlinType enhance(SignatureParts signatureParts, KotlinType kotlinType, List<? extends KotlinType> list, TypeEnhancementInfo typeEnhancementInfo, boolean z) {
        return this.typeEnhancement.enhance(kotlinType, signatureParts.computeIndexedQualifiers(kotlinType, list, typeEnhancementInfo, z), signatureParts.getSkipRawTypeArguments());
    }
}

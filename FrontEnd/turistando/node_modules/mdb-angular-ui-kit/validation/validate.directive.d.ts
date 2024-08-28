import { BooleanInput } from '@angular/cdk/coercion';
import { ElementRef, OnInit, Renderer2 } from '@angular/core';
import * as i0 from "@angular/core";
export declare class MdbValidateDirective implements OnInit {
    private renderer;
    private _elementRef;
    private _validate;
    private _validateSuccess;
    private _validateError;
    get mdbValidate(): boolean;
    set mdbValidate(value: boolean);
    private _mdbValidate;
    get validate(): boolean;
    set validate(value: boolean);
    get validateSuccess(): boolean;
    set validateSuccess(value: boolean);
    get validateError(): boolean;
    set validateError(value: boolean);
    constructor(renderer: Renderer2, _elementRef: ElementRef);
    updateSuccessClass(): void;
    updateErrorClass(): void;
    ngOnInit(): void;
    static ngAcceptInputType_mdbValidate: BooleanInput;
    static ngAcceptInputType_validate: BooleanInput;
    static ngAcceptInputType_validateSuccess: BooleanInput;
    static ngAcceptInputType_validateError: BooleanInput;
    static ɵfac: i0.ɵɵFactoryDeclaration<MdbValidateDirective, never>;
    static ɵdir: i0.ɵɵDirectiveDeclaration<MdbValidateDirective, "[mdbValidate]", never, { "mdbValidate": { "alias": "mdbValidate"; "required": false; }; "validate": { "alias": "validate"; "required": false; }; "validateSuccess": { "alias": "validateSuccess"; "required": false; }; "validateError": { "alias": "validateError"; "required": false; }; }, {}, never, never, false, never>;
}

import { BooleanInput } from '@angular/cdk/coercion';
import { EventEmitter } from '@angular/core';
import * as i0 from "@angular/core";
export declare const MDB_CHECKBOX_VALUE_ACCESSOR: any;
export declare class MdbCheckboxChange {
    element: MdbCheckboxDirective;
    checked: boolean;
}
export declare class MdbCheckboxDirective {
    get checked(): boolean;
    set checked(value: boolean);
    private _checked;
    get value(): any;
    set value(value: any);
    private _value;
    get disabled(): boolean;
    set disabled(value: boolean);
    private _disabled;
    checkboxChange: EventEmitter<MdbCheckboxChange>;
    get isDisabled(): boolean;
    get isChecked(): boolean;
    onCheckboxClick(): void;
    onBlur(): void;
    constructor();
    get changeEvent(): MdbCheckboxChange;
    toggle(): void;
    onCheckboxChange(): void;
    onChange: (_: any) => void;
    onTouched: () => void;
    writeValue(value: any): void;
    registerOnChange(fn: (_: any) => void): void;
    registerOnTouched(fn: () => void): void;
    setDisabledState(isDisabled: boolean): void;
    static ngAcceptInputType_checked: BooleanInput;
    static ngAcceptInputType_disabled: BooleanInput;
    static ɵfac: i0.ɵɵFactoryDeclaration<MdbCheckboxDirective, never>;
    static ɵdir: i0.ɵɵDirectiveDeclaration<MdbCheckboxDirective, "[mdbCheckbox]", never, { "checked": { "alias": "checked"; "required": false; }; "value": { "alias": "value"; "required": false; }; "disabled": { "alias": "disabled"; "required": false; }; }, { "checkboxChange": "checkboxChange"; }, never, never, false, never>;
}

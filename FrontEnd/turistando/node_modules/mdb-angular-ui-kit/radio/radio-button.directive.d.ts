import { BooleanInput } from '@angular/cdk/coercion';
import * as i0 from "@angular/core";
export declare class MdbRadioDirective {
    get name(): string;
    set name(value: string);
    private _name;
    get checked(): boolean;
    set checked(value: boolean);
    private _checked;
    get value(): any;
    set value(value: any);
    private _value;
    get disabled(): boolean;
    set disabled(value: boolean);
    private _disabled;
    get isDisabled(): boolean;
    get isChecked(): boolean;
    get nameAttr(): string;
    constructor();
    _updateName(value: string): void;
    _updateChecked(value: boolean): void;
    _updateDisabledState(value: boolean): void;
    static ngAcceptInputType_checked: BooleanInput;
    static ngAcceptInputType_disabled: BooleanInput;
    static ɵfac: i0.ɵɵFactoryDeclaration<MdbRadioDirective, never>;
    static ɵdir: i0.ɵɵDirectiveDeclaration<MdbRadioDirective, "[mdbRadio]", never, { "name": { "alias": "name"; "required": false; }; "checked": { "alias": "checked"; "required": false; }; "value": { "alias": "value"; "required": false; }; "disabled": { "alias": "disabled"; "required": false; }; }, {}, never, never, false, never>;
}

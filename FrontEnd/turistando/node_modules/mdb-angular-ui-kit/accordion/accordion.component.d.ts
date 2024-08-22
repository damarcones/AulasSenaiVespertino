import { AfterContentInit, QueryList } from '@angular/core';
import { MdbAccordionItemComponent } from './accordion-item.component';
import { BooleanInput } from '@angular/cdk/coercion';
import * as i0 from "@angular/core";
export declare class MdbAccordionComponent implements AfterContentInit {
    items: QueryList<MdbAccordionItemComponent>;
    get borderless(): boolean;
    set borderless(value: boolean);
    private _borderless;
    get flush(): boolean;
    set flush(value: boolean);
    private _flush;
    get multiple(): boolean;
    set multiple(value: boolean);
    private _multiple;
    accordion: boolean;
    get addBorderlessClass(): boolean;
    get addFlushClass(): boolean;
    constructor();
    ngAfterContentInit(): void;
    private _handleMultipleItems;
    static ngAcceptInputType_borderless: BooleanInput;
    static ngAcceptInputType_flush: BooleanInput;
    static ngAcceptInputType_multiple: BooleanInput;
    static ɵfac: i0.ɵɵFactoryDeclaration<MdbAccordionComponent, never>;
    static ɵcmp: i0.ɵɵComponentDeclaration<MdbAccordionComponent, "mdb-accordion", never, { "borderless": { "alias": "borderless"; "required": false; }; "flush": { "alias": "flush"; "required": false; }; "multiple": { "alias": "multiple"; "required": false; }; }, {}, ["items"], ["*"], false, never>;
}

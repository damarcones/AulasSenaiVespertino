import { OnInit, ChangeDetectorRef } from '@angular/core';
import * as i0 from "@angular/core";
export declare class MdbScrollspyLinkDirective implements OnInit {
    private cdRef;
    private document;
    get scrollIntoView(): boolean;
    set scrollIntoView(value: boolean);
    private _scrollIntoView;
    get section(): HTMLElement;
    set section(value: HTMLElement);
    private _section;
    private _id;
    constructor(cdRef: ChangeDetectorRef, document: any);
    get id(): string;
    set id(newId: string);
    scrollspyLink: boolean;
    active: boolean;
    onClick(): void;
    detectChanges(): void;
    assignSectionToId(): void;
    ngOnInit(): void;
    static ɵfac: i0.ɵɵFactoryDeclaration<MdbScrollspyLinkDirective, never>;
    static ɵdir: i0.ɵɵDirectiveDeclaration<MdbScrollspyLinkDirective, "[mdbScrollspyLink]", never, { "scrollIntoView": { "alias": "scrollIntoView"; "required": false; }; "id": { "alias": "mdbScrollspyLink"; "required": false; }; }, {}, never, never, false, never>;
}

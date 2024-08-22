import { ElementRef, OnInit, Renderer2, NgZone, AfterViewInit } from '@angular/core';
import { MdbScrollspyService } from './scrollspy.service';
import * as i0 from "@angular/core";
export declare class MdbScrollspyWindowDirective implements OnInit, AfterViewInit {
    private document;
    private el;
    private renderer;
    private ngZone;
    private scrollSpyService;
    private id;
    get scrollSpyId(): string;
    set scrollSpyId(newId: string);
    private _scrollSpyId;
    offset: number;
    constructor(document: any, el: ElementRef, renderer: Renderer2, ngZone: NgZone, scrollSpyService: MdbScrollspyService);
    isElementInViewport(): boolean;
    updateActiveState(scrollSpyId: string, id: string): void;
    onScroll(): void;
    listenToScroll(): void;
    ngOnInit(): void;
    ngAfterViewInit(): void;
    static ɵfac: i0.ɵɵFactoryDeclaration<MdbScrollspyWindowDirective, never>;
    static ɵdir: i0.ɵɵDirectiveDeclaration<MdbScrollspyWindowDirective, "[mdbScrollspyWindow]", never, { "scrollSpyId": { "alias": "mdbScrollspyWindow"; "required": false; }; "offset": { "alias": "offset"; "required": false; }; }, {}, never, never, false, never>;
}

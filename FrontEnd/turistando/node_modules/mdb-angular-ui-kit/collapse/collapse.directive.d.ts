import { ElementRef, EventEmitter, Renderer2 } from '@angular/core';
import * as i0 from "@angular/core";
export declare class MdbCollapseDirective {
    private _elementRef;
    private _renderer;
    constructor(_elementRef: ElementRef, _renderer: Renderer2);
    collapseClass: boolean;
    collapseShow: EventEmitter<MdbCollapseDirective>;
    collapseShown: EventEmitter<MdbCollapseDirective>;
    collapseHide: EventEmitter<MdbCollapseDirective>;
    collapseHidden: EventEmitter<MdbCollapseDirective>;
    set collapsed(collapsed: boolean);
    get collapsed(): boolean;
    private _collapsed;
    get host(): HTMLElement;
    private _isTransitioning;
    show(): void;
    hide(): void;
    toggle(): void;
    private _reflow;
    private _emulateTransitionEnd;
    static ɵfac: i0.ɵɵFactoryDeclaration<MdbCollapseDirective, never>;
    static ɵdir: i0.ɵɵDirectiveDeclaration<MdbCollapseDirective, "[mdbCollapse]", ["mdbCollapse"], { "collapsed": { "alias": "collapsed"; "required": false; }; }, { "collapseShow": "collapseShow"; "collapseShown": "collapseShown"; "collapseHide": "collapseHide"; "collapseHidden": "collapseHidden"; }, never, never, false, never>;
}

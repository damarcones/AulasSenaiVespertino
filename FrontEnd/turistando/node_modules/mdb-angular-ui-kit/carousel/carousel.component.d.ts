import { BooleanInput } from '@angular/cdk/coercion';
import { AfterViewInit, ChangeDetectorRef, ElementRef, EventEmitter, OnDestroy, QueryList } from '@angular/core';
import { MdbCarouselItemComponent } from './carousel-item.component';
import * as i0 from "@angular/core";
export declare enum Direction {
    UNKNOWN = 0,
    NEXT = 1,
    PREV = 2
}
export declare class MdbCarouselComponent implements AfterViewInit, OnDestroy {
    private _elementRef;
    private _cdRef;
    _items: QueryList<MdbCarouselItemComponent>;
    get items(): MdbCarouselItemComponent[];
    animation: 'slide' | 'fade';
    get controls(): boolean;
    set controls(value: boolean);
    private _controls;
    get dark(): boolean;
    set dark(value: boolean);
    private _dark;
    get indicators(): boolean;
    set indicators(value: boolean);
    private _indicators;
    get ride(): boolean;
    set ride(value: boolean);
    private _ride;
    get interval(): number;
    set interval(value: number);
    private _interval;
    keyboard: boolean;
    pause: boolean;
    wrap: boolean;
    slide: EventEmitter<void>;
    slideChange: EventEmitter<void>;
    get activeSlide(): number;
    set activeSlide(index: number);
    private _activeSlide;
    private _lastInterval;
    private _isPlaying;
    private _isSliding;
    private readonly _destroy$;
    onMouseEnter(): void;
    onMouseLeave(): void;
    display: boolean;
    constructor(_elementRef: ElementRef, _cdRef: ChangeDetectorRef);
    ngAfterViewInit(): void;
    ngOnDestroy(): void;
    private _setActiveSlide;
    private _restartInterval;
    private _resetInterval;
    play(): void;
    stop(): void;
    to(index: number): void;
    next(): void;
    prev(): void;
    private _slide;
    private _animateSlides;
    private _reflow;
    private _emulateTransitionEnd;
    private _getNewSlideIndex;
    private _getNextSlideIndex;
    private _getPrevSlideIndex;
    static ngAcceptInputType_controls: BooleanInput;
    static ngAcceptInputType_dark: BooleanInput;
    static ngAcceptInputType_indicators: BooleanInput;
    static ngAcceptInputType_ride: BooleanInput;
    static ɵfac: i0.ɵɵFactoryDeclaration<MdbCarouselComponent, never>;
    static ɵcmp: i0.ɵɵComponentDeclaration<MdbCarouselComponent, "mdb-carousel", never, { "animation": { "alias": "animation"; "required": false; }; "controls": { "alias": "controls"; "required": false; }; "dark": { "alias": "dark"; "required": false; }; "indicators": { "alias": "indicators"; "required": false; }; "ride": { "alias": "ride"; "required": false; }; "interval": { "alias": "interval"; "required": false; }; "keyboard": { "alias": "keyboard"; "required": false; }; "pause": { "alias": "pause"; "required": false; }; "wrap": { "alias": "wrap"; "required": false; }; }, { "slide": "slide"; "slideChange": "slideChange"; }, ["_items"], ["*"], false, never>;
}

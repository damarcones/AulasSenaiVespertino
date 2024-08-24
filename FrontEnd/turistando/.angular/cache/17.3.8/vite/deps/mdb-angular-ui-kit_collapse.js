import {
  Directive,
  ElementRef,
  EventEmitter,
  HostBinding,
  Input,
  NgModule,
  Output,
  Renderer2,
  fromEvent,
  setClassMetadata,
  take,
  ɵɵclassProp,
  ɵɵdefineDirective,
  ɵɵdefineInjector,
  ɵɵdefineNgModule,
  ɵɵdirectiveInject
} from "./chunk-7VA6EE2T.js";

// ../node_modules/mdb-angular-ui-kit/fesm2022/mdb-angular-ui-kit-collapse.mjs
var TRANSITION_TIME = 350;
var MdbCollapseDirective = class _MdbCollapseDirective {
  _elementRef;
  _renderer;
  constructor(_elementRef, _renderer) {
    this._elementRef = _elementRef;
    this._renderer = _renderer;
  }
  collapseClass = true;
  collapseShow = new EventEmitter();
  collapseShown = new EventEmitter();
  collapseHide = new EventEmitter();
  collapseHidden = new EventEmitter();
  set collapsed(collapsed) {
    if (collapsed !== this._collapsed) {
      collapsed ? this.hide() : this.show();
      this._collapsed = collapsed;
    }
  }
  get collapsed() {
    return this._collapsed;
  }
  _collapsed = true;
  get host() {
    return this._elementRef.nativeElement;
  }
  _isTransitioning = false;
  show() {
    if (this._isTransitioning || !this.collapsed) {
      return;
    }
    this.collapseShow.emit(this);
    this._renderer.removeClass(this.host, "collapse");
    this._renderer.addClass(this.host, "collapsing");
    this._renderer.setStyle(this.host, "height", "0px");
    this._isTransitioning = true;
    const scrollHeight = this.host.scrollHeight;
    fromEvent(this.host, "transitionend").pipe(take(1)).subscribe(() => {
      this._isTransitioning = false;
      this.collapsed = false;
      this._renderer.removeClass(this.host, "collapsing");
      this._renderer.addClass(this.host, "collapse");
      this._renderer.addClass(this.host, "show");
      this._renderer.removeStyle(this.host, "height");
      this.collapseShown.emit(this);
    });
    this._emulateTransitionEnd(this.host, TRANSITION_TIME);
    this._renderer.setStyle(this.host, "height", `${scrollHeight}px`);
  }
  hide() {
    if (this._isTransitioning || this.collapsed) {
      return;
    }
    this.collapseHide.emit(this);
    const hostHeight = this.host.getBoundingClientRect().height;
    this._renderer.setStyle(this.host, "height", `${hostHeight}px`);
    this._reflow(this.host);
    this._renderer.addClass(this.host, "collapsing");
    this._renderer.removeClass(this.host, "collapse");
    this._renderer.removeClass(this.host, "show");
    this._isTransitioning = true;
    fromEvent(this.host, "transitionend").pipe(take(1)).subscribe(() => {
      this._renderer.removeClass(this.host, "collapsing");
      this._renderer.addClass(this.host, "collapse");
      this._isTransitioning = false;
      this.collapsed = true;
      this.collapseHidden.emit(this);
    });
    this._renderer.removeStyle(this.host, "height");
    this._emulateTransitionEnd(this.host, TRANSITION_TIME);
  }
  toggle() {
    if (this._isTransitioning) {
      return;
    }
    this.collapsed = !this.collapsed;
    this.collapsed ? this.hide() : this.show();
  }
  _reflow(element) {
    return element.offsetHeight;
  }
  _emulateTransitionEnd(element, duration) {
    let eventEmitted = false;
    const durationPadding = 5;
    const emulatedDuration = duration + durationPadding;
    fromEvent(element, "transitionend").pipe(take(1)).subscribe(() => {
      eventEmitted = true;
    });
    setTimeout(() => {
      if (!eventEmitted) {
        element.dispatchEvent(new Event("transitionend"));
      }
    }, emulatedDuration);
  }
  static ɵfac = function MdbCollapseDirective_Factory(t) {
    return new (t || _MdbCollapseDirective)(ɵɵdirectiveInject(ElementRef), ɵɵdirectiveInject(Renderer2));
  };
  static ɵdir = ɵɵdefineDirective({
    type: _MdbCollapseDirective,
    selectors: [["", "mdbCollapse", ""]],
    hostVars: 2,
    hostBindings: function MdbCollapseDirective_HostBindings(rf, ctx) {
      if (rf & 2) {
        ɵɵclassProp("collapse", ctx.collapseClass);
      }
    },
    inputs: {
      collapsed: "collapsed"
    },
    outputs: {
      collapseShow: "collapseShow",
      collapseShown: "collapseShown",
      collapseHide: "collapseHide",
      collapseHidden: "collapseHidden"
    },
    exportAs: ["mdbCollapse"]
  });
};
(() => {
  (typeof ngDevMode === "undefined" || ngDevMode) && setClassMetadata(MdbCollapseDirective, [{
    type: Directive,
    args: [{
      // eslint-disable-next-line @angular-eslint/directive-selector
      selector: "[mdbCollapse]",
      exportAs: "mdbCollapse"
    }]
  }], () => [{
    type: ElementRef
  }, {
    type: Renderer2
  }], {
    collapseClass: [{
      type: HostBinding,
      args: ["class.collapse"]
    }],
    collapseShow: [{
      type: Output
    }],
    collapseShown: [{
      type: Output
    }],
    collapseHide: [{
      type: Output
    }],
    collapseHidden: [{
      type: Output
    }],
    collapsed: [{
      type: Input
    }]
  });
})();
var MdbCollapseModule = class _MdbCollapseModule {
  static ɵfac = function MdbCollapseModule_Factory(t) {
    return new (t || _MdbCollapseModule)();
  };
  static ɵmod = ɵɵdefineNgModule({
    type: _MdbCollapseModule,
    declarations: [MdbCollapseDirective],
    exports: [MdbCollapseDirective]
  });
  static ɵinj = ɵɵdefineInjector({});
};
(() => {
  (typeof ngDevMode === "undefined" || ngDevMode) && setClassMetadata(MdbCollapseModule, [{
    type: NgModule,
    args: [{
      declarations: [MdbCollapseDirective],
      exports: [MdbCollapseDirective]
    }]
  }], null, null);
})();
export {
  MdbCollapseDirective,
  MdbCollapseModule
};
//# sourceMappingURL=mdb-angular-ui-kit_collapse.js.map

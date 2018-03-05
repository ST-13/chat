export class Component {

    constructor (targetElement, store = null) {
        this.targetElement = targetElement;
        this.element = document.createElement('div');
        this.store = store;
    }

    getElement () {
        return this.element;
    }

}
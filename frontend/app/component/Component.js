export class Component {

    constructor (targetElement, store = null, elementType = 'div') {
        this.targetElement = targetElement;
        this.element = document.createElement(elementType);
        this.store = store;
    }

    getElement () {
        return this.element;
    }

    setVisible (visible) {
        this.element.hidden = !visible;
    }

    addEventListener (eventType, callback) {
        this.element.addEventListener(eventType, callback);
    }

    removeEventListener (eventType, callback) {
        this.element.removeEventListener(eventType, callback);
    }

}
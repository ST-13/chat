export class Store {

    constructor () {
        this.data = [];
        this.loadEventName = 'load';
    }

    loadData (data) {
        this.data = data;

        let event = new CustomEvent(this.loadEventName, {
            'detail': this.getRange()
        });

        document.dispatchEvent(event);
    }

    getRange () {
        return this.data;
    }
}
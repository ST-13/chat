import {Controller} from "./Controller.js";
import {ChatMessages} from "../component/ChatMessages.js";
import {MessagesStore} from "../store/MessagesStore.js";

export class ChatMessagesController extends Controller {

    init () {
        const targetElement = document.querySelector('.js-app');

        this.store = new MessagesStore();
        this.chatMessages = new ChatMessages(targetElement, this.store);

        this.addSubscriptions();
    }

    addSubscriptions () {
        document.addEventListener('loadChatMessages', this.onLoadChatMessages.bind(this));
        document.addEventListener('messagesStoreLoad', this.onMessagesStoreLoad.bind(this));
    }

    onLoadChatMessages () {
        // TODO delete
        this.store.loadData([
            {
                nickname: 'test',
                text: 'text'
            },
            {}
        ]);
    }

    onMessagesStoreLoad (event) {
        this.chatMessages.render();
    }

}
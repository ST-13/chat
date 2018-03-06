import {Component} from "./Component.js";
import {ChatListStore} from "../store/ChatListStore.js";
import {ChatMessages} from "./ChatMessages.js";
import {ChatList} from "./ChatList.js";
import {MessagesStore} from "../store/MessagesStore.js";
import {SendMessageForm} from "./SendMessageForm.js";

export class Chat extends Component {

    constructor (targetElement) {
        super(targetElement);

        this.chatList = new ChatList(this.element, new ChatListStore());
        this.chatMessages = new ChatMessages(this.element, new MessagesStore());
        this.sendMessageForm = new SendMessageForm(this.element);

        this.subscribe();
    }

    subscribe () {
        this.chatList.addEventListener('chatSelected', this.onChatSelected.bind(this));
    }

    onChatSelected (event) {
        this.chatMessages.load(event.detail.chatId);
    }

    loadContent (userInfo) {
        this.render();
        this.chatList.load(userInfo.id);
    }

    render () {
        this.targetElement.appendChild(this.element);
        this.chatList.render();
        this.chatMessages.render();
        this.sendMessageForm.render();
    }

}
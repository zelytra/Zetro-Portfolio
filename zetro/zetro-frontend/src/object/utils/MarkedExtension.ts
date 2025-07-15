import {marked} from 'marked';

export const metaDataHunter: marked.TokenizerExtension | marked.RendererExtension = {
    name: 'metaDataHunter',
    level: 'inline',
    start(src) {
        return src.match(/%%/)?.index || -1;
    },
    tokenizer(src, tokens) {
        const rule = /%%((?:(?!%%\s).)+)(?:%%\s|$)/g;
        const match = rule.exec(src);
        if (!match) {
            return undefined;
        }

        const token = {
            type: 'metaDataHunter',
            raw: match[0],
            iconLink: match[1],
            tokens: [],
        };
        this.lexer.inline(token.iconLink, token.tokens);
        return token;
    },
    renderer(token) {
        return ''
    },
};

export const infoTag: marked.TokenizerExtension | marked.RendererExtension = {
    name: 'infoTag',
    level: 'inline',
    start(src) {
        return src.match(/::info/)?.index || -1;
    },
    tokenizer(src, tokens) {
        const rule = /::info\s*\n*([\s\S]*?)\n*::/g;
        const match = rule.exec(src);
        if (!match) {
            return undefined;
        }

        const token = {
            type: 'infoTag',
            raw: match[0],
            content: match[1],
            tokens: [],
        };
        this.lexer.inline(token.content, token.tokens);
        return token;
    },
    renderer(token) {
        if (token.content) {
            const rule = /\(\([^)]*\)\)/g
            let html: string = '';
            const title = token.content.split('((')[1].split('))')[0]
            const content = token.content.replace(rule.exec(token.content),"")
            html = html.concat('<div class="content-wrapper info">' +
                '<div class="svg-container">' +
                '<svg class="info" width="32" height="32" viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">' +
                '<path class="fill" opacity="0.2"' +
                ' d="M16 28C22.6274 28 28 22.6274 28 16C28 9.37258 22.6274 4 16 4C9.37258 4 4 9.37258 4 16C4 22.6274 9.37258 28 16 28Z"' +
                ' />' +
                '<path class="stroke"' +
                ' d="M16 28C22.6274 28 28 22.6274 28 16C28 9.37258 22.6274 4 16 4C9.37258 4 4 9.37258 4 16C4 22.6274 9.37258 28 16 28Z"' +
                ' stroke="#5056E0" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>' +
                '<path class="stroke" d="M15 15H16V22H17" stroke="#5056E0" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>' +
                '<path class="fill"' +
                ' d="M16 12C16.8284 12 17.5 11.3284 17.5 10.5C17.5 9.67157 16.8284 9 16 9C15.1716 9 14.5 9.67157 14.5 10.5C14.5 11.3284 15.1716 12 16 12Z"' +
                ' fill="#5056E0"/>' +
                '</svg>' +
                '</div>' +
                '<div class="content">' +
                '<h2  class="info">' + title + '</h2>' +
                '<p>' + content + '</p>' +
                '</div>' +
                '</div>')
            return html;
        } else return ''
    },
};

export const warnTag: marked.TokenizerExtension | marked.RendererExtension = {
    name: 'warnTag',
    level: 'inline',
    start(src) {
        return src.match(/::warn/)?.index || -1;
    },
    tokenizer(src, tokens) {
        const rule = /::warn\s*\n*([\s\S]*?)\n*::/g;
        const match = rule.exec(src);
        if (!match) {
            return undefined;
        }

        const token = {
            type: 'warnTag',
            raw: match[0],
            content: match[1],
            tokens: [],
        };
        this.lexer.inline(token.content, token.tokens);
        return token;
    },
    renderer(token) {
        if (token.content) {
            const rule = /\(\([^)]*\)\)/g
            let html: string = '';
            const title = token.content.split('((')[1].split('))')[0]
            const content = token.content.replace(rule.exec(token.content),"")
            html = html.concat('<div class="content-wrapper warn">' +
                '<div class="svg-container">' +
                '<svg class="warn" width="32" height="32" viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">' +
                '<path class="fill" opacity="0.2"' +
                ' d="M16 28C22.6274 28 28 22.6274 28 16C28 9.37258 22.6274 4 16 4C9.37258 4 4 9.37258 4 16C4 22.6274 9.37258 28 16 28Z"' +
                ' />' +
                '<path class="stroke"' +
                ' d="M16 28C22.6274 28 28 22.6274 28 16C28 9.37258 22.6274 4 16 4C9.37258 4 4 9.37258 4 16C4 22.6274 9.37258 28 16 28Z"' +
                ' stroke="#5056E0" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>' +
                '<path class="stroke" d="M15 15H16V22H17" stroke="#5056E0" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>' +
                '<path class="fill"' +
                ' d="M16 12C16.8284 12 17.5 11.3284 17.5 10.5C17.5 9.67157 16.8284 9 16 9C15.1716 9 14.5 9.67157 14.5 10.5C14.5 11.3284 15.1716 12 16 12Z"' +
                ' fill="#5056E0"/>' +
                '</svg>' +
                '</div>' +
                '<div class="content">' +
                '<h2  class="warn">' + title + '</h2>' +
                '<p>' + content + '</p>' +
                '</div>' +
                '</div>')
            return html;
        } else return ''
    },
};

export const errorTag: marked.TokenizerExtension | marked.RendererExtension = {
    name: 'errorTag',
    level: 'inline',
    start(src) {
        return src.match(/::error/)?.index || -1;
    },
    tokenizer(src, tokens) {
        const rule = /::error\s*\n*([\s\S]*?)\n*::/g;
        const match = rule.exec(src);
        if (!match) {
            return undefined;
        }

        const token = {
            type: 'errorTag',
            raw: match[0],
            content: match[1],
            tokens: [],
        };
        this.lexer.inline(token.content, token.tokens);
        return token;
    },
    renderer(token) {
        if (token.content) {
            const rule = /\(\([^)]*\)\)/g
            let html: string = '';
            const title = token.content.split('((')[1].split('))')[0]
            const content = token.content.replace(rule.exec(token.content),"")
            html = html.concat('<div class="content-wrapper error">' +
                '<div class="svg-container">' +
                '<svg class="error" width="32" height="32" viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">' +
                '<path class="fill" opacity="0.2"' +
                ' d="M16 28C22.6274 28 28 22.6274 28 16C28 9.37258 22.6274 4 16 4C9.37258 4 4 9.37258 4 16C4 22.6274 9.37258 28 16 28Z"' +
                ' />' +
                '<path class="stroke"' +
                ' d="M16 28C22.6274 28 28 22.6274 28 16C28 9.37258 22.6274 4 16 4C9.37258 4 4 9.37258 4 16C4 22.6274 9.37258 28 16 28Z"' +
                ' stroke="#5056E0" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>' +
                '<path class="stroke" d="M15 15H16V22H17" stroke="#5056E0" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>' +
                '<path class="fill"' +
                ' d="M16 12C16.8284 12 17.5 11.3284 17.5 10.5C17.5 9.67157 16.8284 9 16 9C15.1716 9 14.5 9.67157 14.5 10.5C14.5 11.3284 15.1716 12 16 12Z"' +
                ' fill="#5056E0"/>' +
                '</svg>' +
                '</div>' +
                '<div class="content">' +
                '<h2 class="error">' + title + '</h2>' +
                '<p>' + content + '</p>' +
                '</div>' +
                '</div>')
            return html;
        } else return ''
    },
};

import{r as re,a as F,o as K,b as C,c as S,d as n,n as G,u as q,w as ie,v as ce,e as J,t as A,p as X,f as Y,I as te,g as oe,L as de,A as ue,U as _e,P as pe,h as he,i as H,j as fe,k as me,l as ge,m as xe,q as r,s as t,x as o,y as u,F as O,z as ve,B as V,S as be,T as we,C as ye,E as ke,D as Fe,G as Ce,H as $e,J as Se,K as Te,M as Le,N as Ie,O as ze,Q as ne}from"./vendor.96398909.js";const Re=function(){const l=document.createElement("link").relList;if(l&&l.supports&&l.supports("modulepreload"))return;for(const h of document.querySelectorAll('link[rel="modulepreload"]'))s(h);new MutationObserver(h=>{for(const g of h)if(g.type==="childList")for(const e of g.addedNodes)e.tagName==="LINK"&&e.rel==="modulepreload"&&s(e)}).observe(document,{childList:!0,subtree:!0});function c(h){const g={};return h.integrity&&(g.integrity=h.integrity),h.referrerpolicy&&(g.referrerPolicy=h.referrerpolicy),h.crossorigin==="use-credentials"?g.credentials="include":h.crossorigin==="anonymous"?g.credentials="omit":g.credentials="same-origin",g}function s(h){if(h.ep)return;h.ep=!0;const g=c(h);fetch(h.href,g)}};Re();var Be="/assets/verify-1.9abce6f7.jpg",Pe="/assets/verify-2.03abe0a1.jpg",Ae="/assets/verify-3.986b64e8.jpg";var M=(a,l)=>{for(const[c,s]of l)a[c]=s;return a};const Me=a=>(X("data-v-43073ac4"),a=a(),Y(),a),De=["width","height"],Ee=["width","height"],Xe=Me(()=>n("div",{class:"slider--icon"},null,-1)),Ye=[Xe],Oe={class:"slider--text"},Ue={props:{l:{type:Number,default:42},r:{type:Number,default:10},w:{type:Number,default:300},h:{type:Number,default:150},text:{type:String,default:"\u5411\u53F3\u4FA7\u6ED1\u52A8"},accuracy:{type:Number,default:5},show:{type:Boolean,default:!0},bgList:{type:Array,default:()=>[Be,Pe,Ae]}},emits:["refresh","success","fail","again","fulfilled"],setup(a,{emit:l}){const c=a,s=Math.PI,h=(i,_)=>i+_,g=i=>i*i,e=re({sliderActive:!1,sliderSuccess:!1,sliderFail:!1,canvasCtx:null,blockCtx:null,block:null,blockX:void 0,blockY:void 0,L:c.l+c.r*2+3,img:void 0,originX:void 0,originY:void 0,isMouseDown:!1,trail:[],sliderLeft:"0px",sliderMaskWidth:0,success:!1,loadFlag:!1,timestamp:null}),d=F(null),v=F(null),f=()=>{w(),y(),z()},w=()=>{e.block=d.value,e.canvasCtx=v.value.getContext("2d"),e.blockCtx=e.block.getContext("2d")},y=()=>{const i=j(()=>{e.loadFlag=!1,U(),e.canvasCtx.drawImage(i,0,0,c.w,c.h),e.blockCtx.drawImage(i,0,0,c.w,c.h);const _=e.blockY-c.r*2-1,x=e.blockCtx.getImageData(e.blockX,_,e.L,e.L);e.block.width=e.L,e.blockCtx.putImageData(x,0,_)});e.img=i},z=()=>{const i=x=>{if(!e.isMouseDown)return;const $=x.clientX-e.originX,m=x.clientY-e.originY;if($<0||$+40>=c.w)return;e.sliderLeft=$+"px";const b=(c.w-40-20)/(c.w-40)*$;e.block.style.left=b+"px",e.sliderActive=!0,e.sliderMaskWidth=$+"px",e.trail.push(m)},_=x=>{if(!e.isMouseDown||(e.isMouseDown=!1,x.clientX===e.originX))return;e.sliderActive=!1,e.timestamp=new Date-e.timestamp;const{isPass:$,isRobot:m}=W();if($){if(c.accuracy===-1){e.sliderSuccess=!0,e.success=!0,l("success",e.timestamp);return}m?(e.sliderSuccess=!0,e.success=!0,l("success",e.timestamp)):(e.sliderFail=!0,l("again"))}else e.sliderFail=!0,l("fail"),setTimeout(()=>{P()},1e3)};document.addEventListener("mousemove",i),document.addEventListener("mouseup",_)},T=i=>{e.success||(e.originX=i.clientX,e.originY=i.clientY,e.isMouseDown=!0,e.timestamp=new Date)},R=i=>{e.success||(e.originX=i.changedTouches[0].pageX,e.originY=i.changedTouches[0].pageY,e.isMouseDown=!0,e.timestamp=new Date)},I=i=>{if(!e.isMouseDown)return;const _=i.changedTouches[0].pageX-e.originX,x=i.changedTouches[0].pageY-e.originY;if(_<0||_+38>=e.w)return;e.sliderLeft=_+"px";let $=(c.w-40-20)/(c.w-40)*_;e.block.style.left=$+"px",e.sliderActive=!0,e.sliderMaskWidth=_+"px",e.trail.push(x)},B=i=>{if(!e.isMouseDown||(e.isMouseDown=!1,i.changedTouches[0].pageX===this.originX))return;e.sliderActive=!1,e.timestamp=new Date-e.timestamp;const{isPass:_,isRobot:x}=W();if(_){if(c.accuracy===-1){e.sliderSuccess=!0,e.success=!0,l("success",e);return}x?(e.sliderSuccess=!0,e.success=!0,l("success",e)):(e.sliderFail=!0,l("again"))}else e.sliderFail=!0,l("fail"),setTimeout(()=>{P()},1e3)},P=()=>{e.success=!1,e.sliderFail=!1,e.sliderSuccess=!1,e.sliderFail=!1,e.sliderLeft=0,e.block.style.left=0,e.sliderMaskWidth=0;const{w:i,h:_}=c;e.canvasCtx.clearRect(0,0,i,_),e.blockCtx.clearRect(0,0,i,_),e.block.width=i,e.img.src=N(),l("fulfilled")},k=()=>{l("refresh",e),P()},U=()=>{e.blockX=p(e.L+10,c.w-(e.L+10)),e.blockY=p(c.r+10,c.h-(e.L+10)),E(e.canvasCtx,e.blockX,e.blockY,"fill"),E(e.blockCtx,e.blockX,e.blockY,"clip")},E=(i,_,x,$)=>{const{l:m,r:b}=c;i.beginPath(),i.moveTo(_,x),i.arc(_+m/2,x-b+2,b,.72*s,2.26*s),i.lineTo(_+m,x),i.arc(_+m+b-2,x+m/2,b,1.21*s,2.78*s),i.lineTo(_+m,x+m),i.lineTo(_,x+m),i.arc(_+b-2,x+m/2,b+.4,2.76*s,1.24*s,!0),i.lineTo(_,x),i.lineWidth=2,i.fillStyle="rgba(255, 255, 255, 0.7)",i.strokeStyle="rgba(255, 255, 255, 0.7)",i.stroke(),i[$](),i.globalCompositeOperation="destination-over"},j=i=>{const _=document.createElement("img");return _.crossOrigin="Anonymous",_.onload=i,_.error=()=>{console.error("Background image failed to load")},_.src=N(),_},N=()=>{const i=c.bgList.length;return c.bgList[p(0,i-1)]},p=(i,_)=>Math.round(Math.random()*(_-i)+i),W=()=>{const i=e.trail,_=i.reduce(h)/i.length,x=i.map(ee=>ee-_),$=Math.sqrt(x.map(g).reduce(h)/i.length),m=parseInt(e.block.style.left),b=c.accuracy<=1?1:c.accuracy>10?10:c.accuracy;return{isPass:Math.abs(m-e.blockX)<=b,isRobot:_!==$}};return K(()=>{f()}),(i,_)=>(C(),S("div",{class:"sv-box",style:J({width:a.w+"px"}),onselectstart:"return false"},[n("div",{class:G({"bg-mask":q(e).loadFlag})},null,2),ie(n("div",{class:"sv-refresh",onClick:k},null,512),[[ce,a.show]]),n("canvas",{width:a.w,height:a.h,ref:(x,$)=>{$.canvas=x,v.value=x}},null,8,De),n("canvas",{width:a.w,height:a.h,ref:(x,$)=>{$.block=x,d.value=x},class:"canvas-block"},null,8,Ee),n("div",{class:G(["slider",{active:q(e).sliderActive,success:q(e).sliderSuccess,fail:q(e).sliderFail}])},[n("div",{class:"slider--mask",style:J({width:q(e).sliderMaskWidth})},[n("div",{class:"slider--inner",style:J({left:q(e).sliderLeft}),onMousedown:T,onTouchstart:R,onTouchmove:I,onTouchend:B},Ye,36)],4),n("span",Oe,A(a.text),1)],2)],4))}};var je=M(Ue,[["__scopeId","data-v-43073ac4"]]),Ne="/assets/logo.03d6d6da.png";const qe={name:"_header",components:{Icon:te,IconConfigProvider:oe,LocalLanguageZi24Regular:de,Accessibility24Filled:ue,UserTie:_e,Password:pe,ArrowDown:he,validation:je},setup(a,l){const{t:c}=H(),{proxy:s}=ve(),h=fe();me();const g=ge(),e=xe();let d=F("/"),v=F([{label:"\u9996\u9875",key:"/"},{label:"\u5708\u5B50",key:"/circle"},{label:"\u70ED\u95E8",key:"/hot"}]),f=F(v.value[0].label);const w=m=>{console.log(m),e.start(),d.value=m,v.value.forEach(b=>{b.key===m&&(f.value=b.label)}),h.push(m),setTimeout(()=>{e.finish()},100)};K(()=>{let m=window.location.pathname;m==="/home"?d.value="/":d.value=m,v.value.forEach(b=>{b.key===d.value&&(f.value=b.label)})});let y=F("zh");const z=()=>{console.log("\u5207\u6362\u8BED\u8A00",y.value),y.value==="zh"?(s.$i18n.locale="en",y.value="en"):(s.$i18n.locale="zh",y.value="zh")};let T=F(!1);const R=()=>{T.value=!0},I=()=>{T.value=!1};let B=F(!1),P=F({nickname:"xxxxxxxxxxx1111111111111"}),k=F({show:!1,user:"",pass:"",rules:{user:{required:!0,message:"\u8BF7\u8F93\u5165\u8D26\u6237",trigger:"blur"},pass:{required:!0,message:"\u8BF7\u8F93\u5165\u5BC6\u7801",trigger:"blur"}},loadingFlag:!1}),U=F();const E=()=>{console.log("\u767B\u5F55"),k.value.user="",k.value.pass="",k.value.show=!0},j=()=>{if(!T.value){g.error("\u8BF7\u5148\u6ED1\u52A8\u9A8C\u8BC1\u7801",{closable:!0});return}U.value.validate(m=>{m||(k.value.loadingFlag=!0,s.$axios.post("/login",{user:k.value.user,pass:k.value.pass}).then(({data:b})=>{console.log(b),b.succeedFlag?(g.success(b.msg,{closable:!0}),B.value=!0,k.value.show=!1,P.value.nickname=b.data.nickname):g.error(b.msg,{closable:!0}),k.value.loadingFlag=!1}))})},N=()=>{console.log("\u767B\u51FA"),B.value=!1};let p=F({show:!1,user:"",nickname:"",pass:"",pass2:"",rules:{user:[{required:!0,message:"\u8BF7\u8F93\u5165\u90AE\u7BB1",trigger:"blur"},{required:!0,message:"\u90AE\u7BB1\u683C\u5F0F\u4E0D\u5BF9",trigger:"blur",validator:(m,b)=>b===""?!0:/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(b)}],nickname:{required:!0,message:"\u8BF7\u8F93\u5165\u6635\u79F0",trigger:"blur"},pass:{required:!0,message:"\u8BF7\u8F93\u5165\u5BC6\u7801",trigger:"blur"},pass2:[{required:!0,message:"\u8BF7\u518D\u6B21\u8F93\u5165\u5BC6\u7801",trigger:["input","blur"]},{validator:(m,b)=>b===p.value.pass,message:"\u4E24\u6B21\u5BC6\u7801\u8F93\u5165\u4E0D\u4E00\u81F4",trigger:"blur"}]}}),W=F();return{t:c,navAction:d,navOption:v,navText:f,navChange:w,langVar:y,cutLang:z,options:[{label:"\u4FEE\u6539\u5BC6\u7801",key:"updatePass"},{label:"\u4E2A\u4EBA\u7A7A\u95F4",key:"space"},{label:"\u9000\u51FA\u767B\u5F55",key:"logout"}],loginFlag:B,userInfo:P,loginForm:k,loginRef:U,login:E,logout:N,loginOk:j,registerForm:p,registerRef:W,register:()=>{console.log("\u6CE8\u518C"),p.value.user="",p.value.nickname="",p.value.pass="",p.value.pass2="",p.value.show=!0},registerOk:()=>{W.value.validate(m=>{})},handleSelect:m=>{switch(console.log(m),m){case"updatePass":break;case"space":break;case"logout":B.value=!1;break}},succeed:R,refresh:I}}},se=a=>(X("data-v-bc3ed85a"),a=a(),Y(),a),He={id:"_header"},Ve={class:"headerBody"},We={class:"logoContainer"},Ge=se(()=>n("img",{src:Ne,alt:""},null,-1)),Ze={class:"nav"},Ke={class:"navLs",id:"navLs"},Je={class:"menu"},Qe=se(()=>n("span",{class:"search"},null,-1)),et={class:"cutLang"},tt={class:"loginContainer"},ot={key:0,class:"login"},nt={key:1,class:"logout"},st={class:"user omit"},lt={class:"modalBody"},at={class:"modalBody"};function rt(a,l,c,s,h,g){const e=r("n-gradient-text"),d=r("ArrowDown"),v=r("Icon"),f=r("n-button"),w=r("n-dropdown"),y=r("LocalLanguageZi24Regular"),z=r("UserTie"),T=r("n-icon"),R=r("n-input"),I=r("n-form-item"),B=r("Password"),P=r("validation"),k=r("n-form"),U=r("n-scrollbar"),E=r("n-space"),j=r("n-modal"),N=r("Accessibility24Filled");return C(),S(O,null,[n("div",He,[n("div",Ve,[n("span",We,[Ge,n("span",null,[t(e,{size:18,type:"warning"},{default:o(()=>[u(A(s.t("text.logoTex")),1)]),_:1})])]),n("span",Ze,[n("ul",Ke,[n("li",{class:G([s.navAction=="/"?"action":""]),onClick:l[0]||(l[0]=p=>s.navChange("/"))},"\u9996\u9875",2),n("li",{class:G([s.navAction=="/hot"?"action":""]),onClick:l[1]||(l[1]=p=>s.navChange("/hot"))},"\u70ED\u95E8",2),n("li",{class:G([s.navAction=="/circle"?"action":""]),onClick:l[2]||(l[2]=p=>s.navChange("/circle"))},"\u5708\u5B50",2)]),n("span",Je,[t(w,{onSelect:s.navChange,options:s.navOption},{default:o(()=>[t(f,{color:"#fff0cd",class:"minNavBtn"},{default:o(()=>[u(A(s.navText)+" ",1),t(v,{color:"black",size:"18"},{default:o(()=>[t(d)]),_:1})]),_:1})]),_:1},8,["onSelect","options"])]),Qe]),n("span",et,[n("a",{href:"javascript:void(0)",onClick:l[3]||(l[3]=(...p)=>s.cutLang&&s.cutLang(...p))},[t(v,{color:"black",size:"14"},{default:o(()=>[t(y)]),_:1}),u(" "+A(s.t("text.cutLangTxt")),1)])]),n("span",tt,[s.loginFlag?(C(),S("span",nt,[t(w,{options:s.options,onSelect:s.handleSelect},{default:o(()=>[t(f,null,{default:o(()=>[n("span",st,A(s.userInfo.nickname),1)]),_:1})]),_:1},8,["options","onSelect"])])):(C(),S("span",ot,[n("a",{href:"javascript:void(0)",onClick:l[4]||(l[4]=(...p)=>s.login&&s.login(...p))},"\u767B\u5F55"),n("a",{href:"javascript:void(0)",onClick:l[5]||(l[5]=(...p)=>s.register&&s.register(...p))},"\u6CE8\u518C")]))])])]),t(j,{class:"custom-card",show:s.loginForm.show,"onUpdate:show":l[9]||(l[9]=p=>s.loginForm.show=p),preset:"card",style:"width:50%;min-width:300px;max-width:500px;position: fixed;top:100px;left:0;right:0;margin:0 auto;",title:s.t("modal.loginTitle"),size:"huge"},{footer:o(()=>[t(E,{style:"width:175px;float:right"},{default:o(()=>[t(f,{onClick:l[8]||(l[8]=p=>s.loginForm.show=!1)},{default:o(()=>[u(A(s.t("modal.cancelBtn")),1)]),_:1}),t(f,{onClick:s.loginOk,type:"primary",loading:s.loginForm.loadingFlag},{default:o(()=>[u(A(s.t("modal.confirmBtn")),1)]),_:1},8,["onClick","loading"])]),_:1})]),default:o(()=>[n("div",lt,[t(U,{style:{"max-height":"380px"}},{default:o(()=>[t(k,{"label-width":80,model:s.loginForm,size:"medium",ref:"loginRef",rules:s.loginForm.rules},{default:o(()=>[t(I,{label:"\u7528\u6237\u540D",path:"user"},{default:o(()=>[t(R,{value:s.loginForm.user,"onUpdate:value":l[6]||(l[6]=p=>s.loginForm.user=p),maxlength:50,placeholder:"\u8BF7\u8F93\u5165\u90AE\u7BB1"},{prefix:o(()=>[t(T,null,{default:o(()=>[t(z)]),_:1})]),_:1},8,["value"])]),_:1}),t(I,{label:"\u5BC6\u7801",path:"pass"},{default:o(()=>[t(R,{placeholder:"\u8BF7\u8F93\u5165\u5BC6\u7801",value:s.loginForm.pass,"onUpdate:value":l[7]||(l[7]=p=>s.loginForm.pass=p),type:"password","show-password-on":"mousedown",maxlength:15,path:"registerForm.rules.password"},{prefix:o(()=>[t(T,null,{default:o(()=>[t(B)]),_:1})]),_:1},8,["value"])]),_:1}),t(I,{label:"\u9A8C\u8BC1\u7801"},{default:o(()=>[t(P,{onSuccess:s.succeed,onRefresh:s.refresh},null,8,["onSuccess","onRefresh"])]),_:1})]),_:1},8,["model","rules"])]),_:1})])]),_:1},8,["show","title"]),t(j,{class:"custom-card",show:s.registerForm.show,"onUpdate:show":l[15]||(l[15]=p=>s.registerForm.show=p),preset:"card",style:"width:50%;min-width:300px;max-width:600px;position: fixed;top:20px;left:0;right:0;margin:0 auto;",title:s.t("modal.registerTitle"),size:"huge"},{footer:o(()=>[t(E,{style:"width:175px;float:right"},{default:o(()=>[t(f,{onClick:l[14]||(l[14]=p=>s.registerForm.show=!1)},{default:o(()=>[u(A(s.t("modal.cancelBtn")),1)]),_:1}),t(f,{onClick:s.registerOk,type:"primary"},{default:o(()=>[u(A(s.t("modal.confirmBtn")),1)]),_:1},8,["onClick"])]),_:1})]),default:o(()=>[n("div",at,[t(k,{"label-width":80,model:s.registerForm,size:"medium",ref:"registerRef",rules:s.registerForm.rules},{default:o(()=>[t(I,{label:"\u7528\u6237\u540D",path:"user"},{default:o(()=>[t(R,{value:s.registerForm.user,"onUpdate:value":l[10]||(l[10]=p=>s.registerForm.user=p),placeholder:"\u8BF7\u8F93\u5165\u90AE\u7BB1"},{prefix:o(()=>[t(T,null,{default:o(()=>[t(z)]),_:1})]),_:1},8,["value"])]),_:1}),t(I,{label:"\u6635\u79F0",path:"nickname"},{default:o(()=>[t(R,{value:s.registerForm.nickname,"onUpdate:value":l[11]||(l[11]=p=>s.registerForm.nickname=p),placeholder:"\u6635\u79F0"},{prefix:o(()=>[t(T,null,{default:o(()=>[t(N)]),_:1})]),_:1},8,["value"])]),_:1}),t(I,{label:"\u5BC6\u7801",path:"pass"},{default:o(()=>[t(R,{placeholder:"\u8BF7\u8F93\u5165\u5BC6\u7801",value:s.registerForm.pass,"onUpdate:value":l[12]||(l[12]=p=>s.registerForm.pass=p),type:"password","show-password-on":"mousedown",maxlength:15,path:"registerForm.rules.password"},{prefix:o(()=>[t(T,null,{default:o(()=>[t(B)]),_:1})]),_:1},8,["value"])]),_:1}),t(I,{label:"\u518D\u6B21\u8F93\u5165\u5BC6\u7801",path:"pass2"},{default:o(()=>[t(R,{placeholder:"\u8BF7\u8F93\u5165\u5BC6\u7801",value:s.registerForm.pass2,"onUpdate:value":l[13]||(l[13]=p=>s.registerForm.pass2=p),type:"password","show-password-on":"mousedown",maxlength:15,path:"registerForm.rules.reenteredPassword"},{prefix:o(()=>[t(T,null,{default:o(()=>[t(B)]),_:1})]),_:1},8,["value"])]),_:1}),t(I,{label:"\u9A8C\u8BC1\u7801"},{default:o(()=>[t(P,{onSuccess:s.succeed,onRefresh:s.refresh},null,8,["onSuccess","onRefresh"])]),_:1})]),_:1},8,["model","rules"])])]),_:1},8,["show","title"])],64)}var it=M(qe,[["render",rt],["__scopeId","data-v-bc3ed85a"]]);const ct={name:"_footer",components:{},setup(a,l){let c=F(["xxxxx","xxxxx","xxxxxx","xxxxxxxxxxxx"]);return K(()=>{}),{link:c,applyFriend:()=>{console.log("\u7533\u8BF7\u53CB\u60C5\u94FE\u63A5")}}}},Q=a=>(X("data-v-417587a4"),a=a(),Y(),a),dt={id:"_footer"},ut={class:"footerBody"},_t={class:"left"},pt=u("\u9996\u9875"),ht=u("\u70ED\u95E8"),ft=u("\u5708\u5B50"),mt={class:"right"},gt=Q(()=>n("li",null,"\u53CB\u60C5\u94FE\u63A5:",-1)),xt=Q(()=>n("a",{href:"javascript:void(0)"},"\u7533\u8BF7\u53CB\u94FE",-1)),vt=[xt],bt=Q(()=>n("span",{class:"copyright"}," Copyright \xA9 2021 xxxxxxxx ",-1));function wt(a,l,c,s,h,g){const e=r("router-link");return C(),S("div",dt,[n("div",ut,[n("div",_t,[n("ul",null,[n("li",null,[t(e,{to:{path:"/"}},{default:o(()=>[pt]),_:1})]),n("li",null,[t(e,{to:{path:"/hot"}},{default:o(()=>[ht]),_:1})]),n("li",null,[t(e,{to:{path:"/circle"}},{default:o(()=>[ft]),_:1})])])]),n("div",mt,[n("ul",null,[gt,(C(!0),S(O,null,V(s.link,d=>(C(),S("li",{class:"omit",key:d},A(d),1))),128)),n("li",{onClick:l[0]||(l[0]=(...d)=>s.applyFriend&&s.applyFriend(...d))},vt)])])]),bt])}var yt=M(ct,[["render",wt],["__scopeId","data-v-417587a4"]]);const kt={name:"_search",components:{Search28Filled:be},setup(a,l){const{t:c}=H();return{t:c}}},Ft={id:"_search"},Ct={class:"searchGroup"},$t=u(" \u641C\u7D22 ");function St(a,l,c,s,h,g){const e=r("n-input"),d=r("Search28Filled"),v=r("n-icon"),f=r("n-button"),w=r("n-input-group");return C(),S("div",Ft,[n("span",Ct,[t(w,null,{default:o(()=>[t(e,{placeholder:"",autosize:"",size:"large",style:{"min-width":"80%"}}),t(f,{class:"searchBtn"},{default:o(()=>[t(v,{size:"18",color:"black"},{default:o(()=>[t(d)]),_:1}),$t]),_:1})]),_:1})])])}var le=M(kt,[["render",St],["__scopeId","data-v-b5bafdee"]]);const Tt={name:"_topics",components:{Timer16Regular:we,Chat20Regular:ye,EyeRegular:ke,Icon:te,IconConfigProvider:oe},props:["dataLs"],setup(a,l){const{t:c}=H();return{t:c}}},Lt=a=>(X("data-v-8daf243a"),a=a(),Y(),a),It={id:"_topics"},zt={class:"user"},Rt=Lt(()=>n("span",{class:"otherGroup"},[n("span",{class:"nickname"}," xxxxxxxxxxxxxxxxxxx ")],-1)),Bt={class:"content"},Pt={href:""},At={class:"contentBody"},Mt=u(" \u56E0\u4E3A\u7406\u60F3\u6211\u5411\u5F80 \u751F\u547D\u7684\u4E91\u5F69 \u5728\u5E7F\u9614\u7684\u5B87\u5B99\u4E2D \u4E00\u76F4\u662F\u7AE5\u8BDD\u91CC\u7684\u8282\u62CD \u5E7B\u60F3\u5929\u8FB9\u7684\u5927\u6D77 \u6F14\u7ECE\u751F\u547D\u7684\u821E\u53F0 \u884C\u661F\u5728\u8EAB\u8FB9\u8F6C\u6765\u8F6C\u53BB \u53EA\u4E3A\u4E86\u4E00\u4E2A\u7231 \u5929\u4F7F\u98DE\u8FC7\u7684\u82B1\u56ED \u6709\u4E00\u79CD\u795E\u79D8\u7684\u8272\u5F69 \u7B49\u5230\u660E\u5929\u9192\u6765\u540E \u6EE1\u56ED\u82B1\u6735\u4F1A\u4E0D\u4F1A\u5F00 \u6696\u98CE\u5439\u8FC7\u7684\u590F\u5929 \u5439\u4E0D\u53BB\u68A6\u4E2D\u7684\u7B49\u5F85 \u7AE5\u8BDD\u738B\u56FD\u91CC\u7684\u7CBE\u7075\u5FEB\u5FEB\u51FA\u6765 \u61A8\u516B\u9F9F\u6211\u7231\u4F60 \u7231\u4F60\u4F1A\u6709\u597D\u5FC3\u60C5 \u628A\u6240\u6709\u7684\u5FEB\u4E50\u90FD\u7ED9\u4F60 \u65E0\u5FE7\u65E0\u8651\u6211\u4EEC\u5728\u4E00\u8D77 \u61A8\u516B\u9F9F\u6211\u7231\u4F60 \u7231\u4F60\u4F1A\u6709\u597D\u5FC3\u60C5 \u4E0B\u4E00\u4E2A\u5B63\u8282\u540C\u6837\u7F8E\u4E3D \u5E78\u798F\u5C31\u6CA1\u6709\u8DDD\u79BB \u61A8\u516B\u9F9F\u6211\u7231\u4F60 \u7231\u4F60\u4F1A\u6709\u597D\u5FC3\u60C5 \u628A\u6240\u6709\u7684\u5FEB\u4E50\u90FD\u7ED9\u4F60 \u65E0\u5FE7\u65E0\u8651\u6211\u4EEC\u5728\u4E00\u8D77 \u61A8\u516B\u9F9F\u6211\u7231\u4F60 \u7231\u4F60\u4F1A\u6709\u597D\u5FC3\u60C5 \u4E0B\u4E00\u4E2A\u5B63\u8282\u540C\u6837\u7F8E\u4E3D \u5E78\u798F\u5C31\u6CA1\u6709\u8DDD\u79BB "),Dt={key:0,class:"cover",src:"https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fuploads.5068.com%2Fallimg%2F1712%2F144-1G209191R5.jpg&refer=http%3A%2F%2Fuploads.5068.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1636810345&t=355cf192ce14f93d248fbe5bc6e3b29b"},Et={class:"statistics"},Xt=u(" 999 "),Yt=u(" 100 "),Ot=u(" 2021-10-13 ");function Ut(a,l,c,s,h,g){const e=r("n-avatar"),d=r("n-ellipsis"),v=r("EyeRegular"),f=r("n-icon"),w=r("Chat20Regular"),y=r("Timer16Regular");return C(),S("div",It,[n("ul",null,[(C(),S(O,null,V(10,z=>n("li",null,[n("span",zt,[t(e,{class:"head",round:"",size:"large",src:"https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg"}),Rt]),n("span",Bt,[n("a",Pt,[n("div",At,[t(d,{"line-clamp":"5",tooltip:!1},{default:o(()=>[Mt]),_:1})]),z%2==1?(C(),S("img",Dt)):Fe("",!0)])]),n("span",Et,[n("span",null,[t(f,{size:"20",color:"#9c9898"},{default:o(()=>[t(v)]),_:1}),Xt]),n("span",null,[t(f,{size:"20",color:"#9c9898"},{default:o(()=>[t(w)]),_:1}),Yt]),n("span",null,[t(f,{size:"20",color:"#9c9898"},{default:o(()=>[t(y)]),_:1}),Ot])])])),64))])])}var ae=M(Tt,[["render",Ut],["__scopeId","data-v-8daf243a"]]);const jt={name:"Home",components:{search:le,topics:ae},setup(a,l){const{t:c}=H();return{t:c}}},D=a=>(X("data-v-2f6fee36"),a=a(),Y(),a),Nt={id:"Home"},qt={class:"homeBody"},Ht={class:"papers"},Vt=D(()=>n("br",null,null,-1)),Wt={class:"nextPage"},Gt=u("\u52A0\u8F7D\u66F4\u591A"),Zt=D(()=>n("br",null,null,-1)),Kt={hoverable:"",class:"other"},Jt=u("\u70ED\u95E8\u5E16\u5B50"),Qt=D(()=>n("ul",null,[n("li",null,[n("a",{href:"#"}," xxxxxxxxxxxx ")]),n("li",null,[n("a",{href:"#"}," xxxxxxxxxxxx ")]),n("li",null,[n("a",{href:"#"}," xxxxxxxxxxxx ")])],-1)),eo=D(()=>n("br",null,null,-1)),to=u("\u7CBE\u9009\u5E16\u5B50"),oo=D(()=>n("ul",null,[n("li",null,[n("a",{href:"#"}," xxxxxxxxxxxx ")]),n("li",null,[n("a",{href:"#"}," xxxxxxxxxxxx ")]),n("li",null,[n("a",{href:"#"}," xxxxxxxxxxxx ")])],-1)),no=D(()=>n("br",null,null,-1)),so=u("\u516C\u544A"),lo=D(()=>n("ul",null,[n("li",null,[n("a",{href:"#"}," xxxxxxxxxxxx ")]),n("li",null,[n("a",{href:"#"}," xxxxxxxxxxxx ")]),n("li",null,[n("a",{href:"#"}," xxxxxxxxxxxx ")])],-1)),ao=D(()=>n("br",null,null,-1));function ro(a,l,c,s,h,g){const e=r("search"),d=r("n-card"),v=r("topics"),f=r("n-button"),w=r("n-text"),y=r("n-h6");return C(),S("div",Nt,[t(d,{hoverable:""},{default:o(()=>[t(e)]),_:1}),n("div",qt,[n("div",Ht,[t(v,{class:""}),Vt,n("span",Wt,[t(f,{type:"success",ghost:""},{default:o(()=>[Gt]),_:1})]),Zt]),n("div",Kt,[t(d,{hoverable:""},{default:o(()=>[t(y,{prefix:"bar","align-text":"",type:"warning"},{default:o(()=>[t(w,{type:"warning"},{default:o(()=>[Jt]),_:1})]),_:1}),Qt]),_:1}),eo,t(d,{hoverable:""},{default:o(()=>[t(y,{prefix:"bar","align-text":"",type:"warning"},{default:o(()=>[t(w,{type:"warning"},{default:o(()=>[to]),_:1})]),_:1}),oo]),_:1}),no,t(d,{hoverable:""},{default:o(()=>[t(y,{prefix:"bar","align-text":"",type:"warning"},{default:o(()=>[t(w,{type:"warning"},{default:o(()=>[so]),_:1})]),_:1}),lo]),_:1}),ao])])])}var io=M(jt,[["render",ro],["__scopeId","data-v-2f6fee36"]]);const co={class:"body"},uo={setup(a){return(l,c)=>{const s=r("n-message-provider"),h=r("n-layout-header"),g=r("router-view"),e=r("n-layout-content"),d=r("n-layout-footer"),v=r("n-layout"),f=r("n-loading-bar-provider");return C(),Ce(f,null,{default:o(()=>[t(v,null,{default:o(()=>[t(h,null,{default:o(()=>[t(s,null,{default:o(()=>[t(it)]),_:1})]),_:1}),t(e,{"content-style":"padding: 24px;"},{default:o(()=>[n("div",co,[t(g)])]),_:1}),t(d,null,{default:o(()=>[t(yt)]),_:1})]),_:1})]),_:1})}}};var _o={btn:{loginTxt:"\u767B\u5F55"},select:{},text:{logoTex:"acorn \u6A61\u679C\u793E\u533A",cutLangTxt:"English"},modal:{loginTitle:"\u767B\u5F55",registerTitle:"\u6CE8\u518C",cancelBtn:"\u53D6\u6D88",confirmBtn:"\u786E\u5B9A"}},po={btn:{loginTxt:"\u767B\u5F55"},select:{},text:{logoTex:"acorn BBS",cutLangTxt:"\u4E2D\u6587"}};const ho=$e({legacy:!1,globalInjection:!0,locale:"zh",messages:{zh:_o,en:po}});const fo={name:"Circle",components:{search:le,Search12Filled:Se},setup(a,l){const{t:c}=H();let s=F([]),h=F([]),g=F([]),e=F({ls:[],totalPage:100,page:0});const d=y=>{console.log(y)};let v=F(""),f=F(!1);return{t:c,attentionLs:s,recommendLs:h,officialLs:g,otherInfo:e,pageChange:d,srarchText:v,loadingFlag:f,search:()=>{f.value=!0}}}},L=a=>(X("data-v-e27b45a8"),a=a(),Y(),a),mo={id:"Circle"},go=L(()=>n("span",{class:"moduleTitle"},"\u6211\u5173\u6CE8\u7684",-1)),xo={class:"attention"},vo=u(" xxxx "),bo=u(" \u8D27\u5E01\u662F\u4E3A\u4E86\u63D0\u9AD8\u4EA4\u6613\u6548\u7387\u800C\u7528\u4E8E\u4EA4\u6362\u7684\u4E2D\u4ECB\u5546\u54C1\u3002\u8D27\u5E01\u6709\u591A\u79CD\u5F62\u5F0F\uFF0C\u5982\u8D1D\u58F3\u7CAE\u98DF\u7B49\u81EA\u7136\u7269\u3001\u91D1\u5C5E\u7EB8\u5F20\u7B49\u52A0\u5DE5\u54C1\u3001\u94F6\u884C\u5361\u4FE1\u7528\u5361\u7B49\u78C1\u6761\u5361\u3001\u79FB\u52A8\u652F\u4ED8\u52A0\u5BC6\u8D27\u5E01\u7B49APP\u3002 "),wo=u(" \u5173\u6CE8\u4EBA\u6570:xxx "),yo=u(" \u8FDB\u5165 "),ko=u(" \u5173\u6CE8 "),Fo=L(()=>n("br",null,null,-1)),Co=L(()=>n("hr",null,null,-1)),$o=L(()=>n("br",null,null,-1)),So=L(()=>n("span",{class:"moduleTitle"},"\u63A8\u8350\u7248\u5757",-1)),To={class:""},Lo=u(" xxxx "),Io=u(" \u8D27\u5E01\u662F\u4E3A\u4E86\u63D0\u9AD8\u4EA4\u6613\u6548\u7387\u800C\u7528\u4E8E\u4EA4\u6362\u7684\u4E2D\u4ECB\u5546\u54C1\u3002\u8D27\u5E01\u6709\u591A\u79CD\u5F62\u5F0F\uFF0C\u5982\u8D1D\u58F3\u7CAE\u98DF\u7B49\u81EA\u7136\u7269\u3001\u91D1\u5C5E\u7EB8\u5F20\u7B49\u52A0\u5DE5\u54C1\u3001\u94F6\u884C\u5361\u4FE1\u7528\u5361\u7B49\u78C1\u6761\u5361\u3001\u79FB\u52A8\u652F\u4ED8\u52A0\u5BC6\u8D27\u5E01\u7B49APP\u3002 "),zo=u(" \u5173\u6CE8\u4EBA\u6570:xxx "),Ro=u(" \u8FDB\u5165 "),Bo=u(" \u5173\u6CE8 "),Po=L(()=>n("br",null,null,-1)),Ao=L(()=>n("hr",null,null,-1)),Mo=L(()=>n("br",null,null,-1)),Do=L(()=>n("span",{class:"moduleTitle"},"\u5B98\u65B9\u677F\u5757",-1)),Eo={class:""},Xo=u(" xxxx "),Yo=u(" \u8D27\u5E01\u662F\u4E3A\u4E86\u63D0\u9AD8\u4EA4\u6613\u6548\u7387\u800C\u7528\u4E8E\u4EA4\u6362\u7684\u4E2D\u4ECB\u5546\u54C1\u3002\u8D27\u5E01\u6709\u591A\u79CD\u5F62\u5F0F\uFF0C\u5982\u8D1D\u58F3\u7CAE\u98DF\u7B49\u81EA\u7136\u7269\u3001\u91D1\u5C5E\u7EB8\u5F20\u7B49\u52A0\u5DE5\u54C1\u3001\u94F6\u884C\u5361\u4FE1\u7528\u5361\u7B49\u78C1\u6761\u5361\u3001\u79FB\u52A8\u652F\u4ED8\u52A0\u5BC6\u8D27\u5E01\u7B49APP\u3002 "),Oo=u(" \u5173\u6CE8\u4EBA\u6570:xxx "),Uo=u(" \u8FDB\u5165 "),jo=u(" \u5173\u6CE8 "),No=L(()=>n("br",null,null,-1)),qo=L(()=>n("hr",null,null,-1)),Ho=L(()=>n("br",null,null,-1)),Vo={class:"moduleTitle"},Wo=u(" \u5176\u4ED6\u7248\u5757 "),Go={class:""},Zo=u(" xxxx "),Ko=u(" \u8D27\u5E01\u662F\u4E3A\u4E86\u63D0\u9AD8\u4EA4\u6613\u6548\u7387\u800C\u7528\u4E8E\u4EA4\u6362\u7684\u4E2D\u4ECB\u5546\u54C1\u3002\u8D27\u5E01\u6709\u591A\u79CD\u5F62\u5F0F\uFF0C\u5982\u8D1D\u58F3\u7CAE\u98DF\u7B49\u81EA\u7136\u7269\u3001\u91D1\u5C5E\u7EB8\u5F20\u7B49\u52A0\u5DE5\u54C1\u3001\u94F6\u884C\u5361\u4FE1\u7528\u5361\u7B49\u78C1\u6761\u5361\u3001\u79FB\u52A8\u652F\u4ED8\u52A0\u5BC6\u8D27\u5E01\u7B49APP\u3002 "),Jo=u(" \u5173\u6CE8\u4EBA\u6570:xxx "),Qo=u(" \u8FDB\u5165 "),en=u(" \u5173\u6CE8 "),tn=L(()=>n("br",null,null,-1)),on=L(()=>n("br",null,null,-1)),nn=L(()=>n("br",null,null,-1));function sn(a,l,c,s,h,g){const e=r("cash-icon"),d=r("n-icon"),v=r("n-avatar"),f=r("n-ellipsis"),w=r("n-button"),y=r("n-space"),z=r("n-thing"),T=r("n-card"),R=r("n-input"),I=r("Search12Filled"),B=r("n-input-group"),P=r("n-pagination");return C(),S("div",mo,[go,n("ul",xo,[(C(),S(O,null,V(5,k=>n("li",null,[t(T,{hoverable:""},{default:o(()=>[t(z,null,{avatar:o(()=>[t(v,null,{default:o(()=>[t(d,null,{default:o(()=>[t(e)]),_:1})]),_:1})]),header:o(()=>[vo]),footer:o(()=>[wo]),action:o(()=>[t(y,null,{default:o(()=>[t(w,{size:"small"},{default:o(()=>[yo]),_:1}),t(w,{size:"small"},{default:o(()=>[ko]),_:1})]),_:1})]),default:o(()=>[t(f,{"line-clamp":"3",tooltip:!1},{default:o(()=>[bo]),_:1})]),_:1})]),_:1})])),64))]),Fo,Co,$o,So,n("ul",To,[(C(),S(O,null,V(4,k=>n("li",null,[t(T,{hoverable:""},{default:o(()=>[t(z,null,{avatar:o(()=>[t(v,null,{default:o(()=>[t(d,null,{default:o(()=>[t(e)]),_:1})]),_:1})]),header:o(()=>[Lo]),footer:o(()=>[zo]),action:o(()=>[t(y,null,{default:o(()=>[t(w,{size:"small"},{default:o(()=>[Ro]),_:1}),t(w,{size:"small"},{default:o(()=>[Bo]),_:1})]),_:1})]),default:o(()=>[t(f,{"line-clamp":"3",tooltip:!1},{default:o(()=>[Io]),_:1})]),_:1})]),_:1})])),64))]),Po,Ao,Mo,Do,n("ul",Eo,[(C(),S(O,null,V(4,k=>n("li",null,[t(T,{hoverable:""},{default:o(()=>[t(z,null,{avatar:o(()=>[t(v,null,{default:o(()=>[t(d,null,{default:o(()=>[t(e)]),_:1})]),_:1})]),header:o(()=>[Xo]),footer:o(()=>[Oo]),action:o(()=>[t(y,null,{default:o(()=>[t(w,{size:"small"},{default:o(()=>[Uo]),_:1}),t(w,{size:"small"},{default:o(()=>[jo]),_:1})]),_:1})]),default:o(()=>[t(f,{"line-clamp":"3",tooltip:!1},{default:o(()=>[Yo]),_:1})]),_:1})]),_:1})])),64))]),No,qo,Ho,n("span",Vo,[Wo,t(B,{class:"otherModuleSearch"},{default:o(()=>[t(R,{style:{width:"55%"},placeholder:"",modelValue:s.srarchText,"onUpdate:modelValue":l[0]||(l[0]=k=>s.srarchText=k)},null,8,["modelValue"]),t(w,{type:"primary",class:"btn",id:"searchBtn",onClick:s.search,loading:s.loadingFlag},{default:o(()=>[t(d,{size:"18"},{default:o(()=>[t(I)]),_:1})]),_:1},8,["onClick","loading"])]),_:1})]),n("ul",Go,[(C(),S(O,null,V(8,k=>n("li",null,[t(T,{hoverable:""},{default:o(()=>[t(z,null,{avatar:o(()=>[t(v,null,{default:o(()=>[t(d,null,{default:o(()=>[t(e)]),_:1})]),_:1})]),header:o(()=>[Zo]),footer:o(()=>[Jo]),action:o(()=>[t(y,null,{default:o(()=>[t(w,{size:"small"},{default:o(()=>[Qo]),_:1}),t(w,{size:"small"},{default:o(()=>[en]),_:1})]),_:1})]),default:o(()=>[t(f,{"line-clamp":"3",tooltip:!1},{default:o(()=>[Ko]),_:1})]),_:1})]),_:1})])),64))]),tn,on,t(P,{modelValue:s.otherInfo.page,"onUpdate:modelValue":l[1]||(l[1]=k=>s.otherInfo.page=k),"page-count":s.otherInfo.totalPage,"page-slot":5,"onUpdate:page":s.pageChange,style:{margin:"0 auto","text-align":"center"}},null,8,["modelValue","page-count","onUpdate:page"]),nn])}var ln=M(fo,[["render",sn],["__scopeId","data-v-e27b45a8"]]);const an={name:"Hot",components:{topics:ae},setup(a,l){const{t:c}=H();let s=[{label:"\u6708\u699C",key:"month"},{label:"\u5468\u699C",key:"week"},{label:"\u65E5\u699C",key:"day"}],h=F("\u6708\u699C");return F("month"),{t:c,sortOptions:s,sortSelect:e=>{console.log(e);for(let d=0;d<s.length;d++)if(console.log(s[d].key==e),s[d].key==e){h.value=s[d].label;break}},sortTxt:h}}},rn=a=>(X("data-v-7f92d6ae"),a=a(),Y(),a),cn={id:"Hot"},dn=rn(()=>n("br",null,null,-1));function un(a,l,c,s,h,g){const e=r("n-button"),d=r("n-dropdown"),v=r("topics");return C(),S("div",cn,[t(d,{trigger:"hover",onSelect:s.sortSelect,options:s.sortOptions},{default:o(()=>[t(e,null,{default:o(()=>[u(" \u6392\u5E8F\uFF1A"+A(s.sortTxt),1)]),_:1})]),_:1},8,["onSelect","options"]),dn,t(v,{class:"papers"})])}var _n=M(an,[["render",un],["__scopeId","data-v-7f92d6ae"]]);const pn=[{path:"/",name:"",component:io},{path:"/home",name:"home",redirect:"/"},{path:"/circle",name:"circle",component:ln},{path:"/hot",name:"hot",component:_n}],hn=Te({history:Le(),routes:pn}),Z=Ie(uo);Z.use(ze);ne.interceptors.request.use(a=>{console.log("\u8BF7\u6C42\u62E6\u622A");let l=localStorage.getItem("token");return l&l!="null"&&(console.log("\u8BBE\u7F6E\u8BF7\u6C42\u5934",l),a.headers.token=l),a},a=>{console.log(a),Promise.reject(a)});Z.config.globalProperties.$axios=ne;Z.use(ho);Z.use(hn);Z.mount("#app");
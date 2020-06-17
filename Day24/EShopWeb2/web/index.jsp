<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="blocks/header.jsp"%>

                    
                    <!-- Right column: content -->
<div class="tm-right-column">
    <div class="tm-content-div">
                            <!-- Welcome section -->
                            <section id="welcome" class="tm-section">
                                <header>
                                    <h2 class="tm-blue-text tm-welcome-title tm-margin-b-45">Welcome to Neaty Design</h2>
                                </header>
                                <p>Neaty is simple and clean design HTML CSS template for any kind of website. Feel free to use this layout. Please tell your friends about TemplateMo website. Thank you. Suspendisse imperdiet, felis eu hendrerit pretium, sapien mauris blandit arcu, et accumsan neque est ut erat. Vivamus eget tellus euismod, interdum nibh at, eleifend justo. Quisque placerat ante in ex tempor, ultrices bibendum nunc finibus. Etiam luctus nec eros vel pulvinar.</p>
                            </section>
                            <!-- About section -->
                            <section id="about" class="tm-section">
                                <div class="row">                                                                
                                    <div class="col-lg-8 col-md-7 col-sm-12 col-xs-12 push-lg-4 push-md-5">
                                        
                                        <header>
                                            <h2 class="tm-blue-text tm-section-title tm-margin-b-45">About the team</h2>
                                        </header>
                                        <p>Sed turpis nunc, laoreet sit amet fermentum sed, euismod ac justo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.</p>
                                        <p>Donec ut lectus semper, sollicitudin risus blandit, mattis felis. Nam non malesuada odio. Vestibulum vaius, arcu eget rutrum consequat, arcu lacus imperdiet arcu, id pulvinar arcu erat vel magna.</p>
                                        <p>Ut commodo malesuada eros, quis consequat ante tincidunt ut. Suspendisse malesuada augue vitae nisi sollicitudin placerat.</p>
                                        <a href="#" class="tm-button tm-button-wide">Read More</a>  
                                    </div>

                                    <div class="col-lg-4 col-md-5 col-sm-12 col-xs-12 pull-lg-8 pull-md-7 tm-about-img-container">
                                        <img src="assets/img/neaty-02.jpg" alt="Image" class="img-fluid">    
                                    </div>  
                                </div>                            
                            </section>  

                            
                            <!-- Contact Us section -->
                            <section id="contact" class="tm-section">
                                <header><h2 class="tm-blue-text tm-section-title tm-margin-b-30">Contact Us</h2></header>

                                <div class="row">
                                    <div class="col-lg-6">
                                        <form action="#contact" method="post" class="contact-form">
                                            <div class="form-group">
                                                <input type="text" id="contact_name" name="contact_name" class="form-control" placeholder="Name"  required/>
                                            </div>
                                            <div class="form-group">
                                                <input type="email" id="contact_email" name="contact_email" class="form-control" placeholder="Email"  required/>
                                            </div>
                                            <div class="form-group">
                                                <textarea id="contact_message" name="contact_message" class="form-control" rows="9" placeholder="Message" required></textarea>
                                            </div>                                            
                                            <button type="submit" class="float-right tm-button">Send</button>
                                        </form>    
                                    </div>
                                    
                                    <div class="col-lg-6 tm-contact-right">
                                        <p>
                                        Nullam vivera fermentum purus id blandit. Phasellus lacus mi, porta vel sodales nec, faucibus non eros. Nulla at quam vel risus laoreet tincidunt in in sem.    
                                        </p>
                                        <address>
                                            11/22 Etiam mauris erat,<br>
                                            Vestibulum eu augue nec, 10220<br>
                                            Nam consequat
                                        </address>
                                    </div>
                                </div>
                                
                            </section>
                        
                        </div>  
                        
                    </div> <!-- Right column: content -->
<%@include file="blocks/footer.jsp"%>